import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CampaignEdit from './CampaignEdit';
import CampaignList from './CampaignList';
import KeywordList from './KeywordList';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/campaigns' exact={true} component={CampaignList}/>
          <Route path='/campaigns/keywords/:id' component={KeywordList}></Route>
          <Route path='/campaigns/:id,name' component={CampaignEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;