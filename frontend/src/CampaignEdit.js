import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class CampaignEdit extends Component{

    emptyItem = {
        name:'',
        bidAmount:'',
        campaignFunds:'',
        status:'',
        town:'',
        radius:'',
        keywords:''
    };

    constructor(props){
        super(props)
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)
    }

    async componentDidMount(){
        if (this.props.match.params.id !== 'new'){
            const campaign = await (await fetch(`/campaigns/${this.props.match.params.id}`)).json();
            this.setState({item: campaign});
        }
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event) {
        event.preventDefault();
        const {item} = this.state;

        await fetch('/campaigns' + (item.id ? "/" + item.id : ''), {
            method: (item.id) ? "PUT" : "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/campaigns');
        window.location.reload(false);
    }


    render() {
        const {item} = this.state
        const title = <h2>{item.id ? 'Edit campaign' : 'Add campaign'}</h2>;
        
        return <div>
            <AppNavbar />
                <Container>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="name">Name</Label>
                            <Input type="text" name="name" id="name" value={item.name||''} 
                            onChange={this.handleChange} required={true} autoComplete="name"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="bidAmount">Bid amount</Label>
                            <Input type="number" name="bidAmount" id="bidAmount" value={item.bidAmount||''} 
                            onChange={this.handleChange} step="1" required={true} min="0" pattern='>=0' autoComplete="bidAmount"/>
                        </FormGroup>
                        <FormGroup>
                            <div className="row">
                                <Label for="status">Status</Label>
                                <select type="text" name="status" id="status" value={item.status||''} onChange={this.handleChange}>
                                    <option name="status" id="status" value="true">Off</option>
                                    <option name="status" id="status" value="true">On</option>
                                </select>
                            </div>
                            {/* <Input type="text" name="status" id="status" value={item.status||''} 
                            onChange={this.handleChange} autoComplete="status"/> */}
                        </FormGroup>
                        <FormGroup>
                            <Label for="town">Town</Label>
                            <Input type="text" name="town" id="town" value={item.town||''} 
                            onChange={this.handleChange} required={true} autoComplete="town"/>
                        </FormGroup>
                        <FormGroup>
                            <Label for="radius">Radius</Label>
                            <Input type="number" name="radius" id="radius" value={item.radius||''} 
                            onChange={this.handleChange} step="1" required={true} min="0" autoComplete="radius"/>
                        </FormGroup>
                        <FormGroup>
                            <Button color="primary" type="submit">Save</Button>{' '}
                            <Button color="secondary" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to="/campaigns">Cancel</Link></Button>
                        </FormGroup>
                    </Form>
                </Container>
        </div>
    }


}
export default withRouter(CampaignEdit);