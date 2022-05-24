import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';

class CampaignEdit extends Component{

    emptyItem = {
        word: '',
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
            const keyword = await (await fetch(`/campaigns/keyword/${this.props.match.params.id}`)).json();
            this.setState({item: keyword});
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

        await fetch("/campaigns/keyword" + (item.id ? "/" + item.id : ''), {
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
        const title = <h2>{item.id ? 'Edit keyword' : 'Add keyword'}</h2>;
        
        return <div>
            <AppNavbar />
                <Container>
                    {title}
                    <Form onSubmit={this.handleSubmit}>
                        <FormGroup>
                            <Label for="word">Word</Label>
                            <Input type="text" name="word" id="word" value={item.word||''} 
                            onChange={this.handleChange} required={true} autoComplete="word"/>
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