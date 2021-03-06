import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class CampaignList extends Component {

    constructor(props) {
        super(props);
        this.state = {campaigns: [], currentBalance: 0};
        this.remove = this.remove.bind(this);
    }

    componentDidMount(){
        fetch('/campaigns')
            .then(response=>response.json())
            .then(data=>this.setState({campaigns: data}))
        fetch('/campaigns/balance')
            .then(response => response.json())
            .then(data => this.setState({currentBalance: data}))
    }

    async remove(id){
        await fetch(`/campaigns/${id}`, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
                }
        }).then(() => {
            let updateCampaigns = [...this.state.campaigns].filter(i=>i.id !==id);
            this.setState({campaigns: updateCampaigns});
        });
    }



    render() {
        const {currentBalance, campaigns, isLoading} = this.state;

        if(isLoading){
            return <p>Loading...</p>;
        }

        const campaignList = campaigns.map(campaign => {
            return <tr key={campaign.id}>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.name}</td>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.bidAmount}</td>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.campaignFunds}</td>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.status ? 'on': 'off'}</td>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.town}</td>
                <td style={{whiteSpace: 'nowrap'}}> {campaign.radius}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="success" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to={"/campaigns/keyword/new/"+campaign.id}>Add</Link></Button>
                        <Button size="sm" color='primary' onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to={"/campaigns/keywords/"+campaign.id}>Show</Link></Button>
                    </ButtonGroup>
                </td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to={"/campaigns/"+campaign.id}>Edit</Link></Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(campaign.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });


        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                        <Button color="success" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to="/campaigns/new">Add Campaign</Link></Button>
                    </div>
                    <div className="float-right">
                        <h4> Current balance: {currentBalance} </h4>
                    </div>
                    <h3>Campaigns</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                            <th width="9%">Name</th>
                            <th width="13%">Bid amount</th>
                            <th width="19%">Campaign funds</th>
                            <th width="12%">Status</th>
                            <th width="11%">Town</th>
                            <th width="9%">Radius</th>
                            <th width="15%">Keywords</th>
                            <th width="12%">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {campaignList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }

}

export default CampaignList;

