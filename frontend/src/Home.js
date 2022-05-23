import React, { Component } from 'react';
import './App.css';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <AppNavbar/>
                <Container fluid>
                    <Button color="success" onClick={() => window.location.reload(false)}><Link style={{ color: '#FFF' }} to="/campaigns">Run</Link></Button>
                </Container>
            </div>
        )
    }
}
export default Home;