import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

class KeywordList extends Component {

    constructor(props) {
        super(props);
        this.state = {keywords: []};
        // this.remove = this.remove.bind(this);
    }

    componentDidMount(){
        fetch(window.location.href)
            .then(response=>response.json())
            .then(data=>this.setState({keywords: data}))
        console.log(this.props.id)
    }

    // async remove(id){
    //     await fetch(`/campaigns/${id}`, {
    //     method: 'DELETE',
    //     headers: {
    //         'Accept': 'application/json',
    //         'Content-Type': 'application/json'
    //             }
    //     }).then(() => {
    //         let updateCampaigns = [...this.state.campaigns].filter(i=>i.id !==id);
    //         this.setState({campaigns: updateCampaigns});
    //     });
    // }

    render() {
        const {keywords, isLoading} = this.state;

        if(isLoading){
            return <p>Loading...</p>;
        }

        const keywordList = Object.values(keywords).map(keyWord => {
            return <tr key={keyWord.id}>
                <td style={{whiteSpace: 'nowrap'}}> {keyWord.word}</td>
                {/* <td>
                    <ButtonGroup>
                        <Button size="sm" color="primary" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to={"/campaigns/"+campaign.id}>Edit</Link></Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(campaign.id)}>Delete</Button>
                    </ButtonGroup>
                </td> */}
            </tr>
        });


        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <div className="float-right">
                    <Button color="secondary" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to="/campaigns">Back</Link></Button>
                    </div>
                    <h3>Keywords</h3>
                    <Table className="mt-4">
                        <thead>
                            <tr>
                            <th width="10%">Word</th>
                            </tr>
                        </thead>
                        <tbody>
                            {keywordList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }

}

export default KeywordList;

