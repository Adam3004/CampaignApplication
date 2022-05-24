import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CampaignEdit from './CampaignEdit';
import CampaignList from './CampaignList';
import KeywordList from './KeywordList';
import KeywordEdit from './KeywordEdit';


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/campaigns' exact={true} component={CampaignList}/>
          <Route path='/campaigns/keywords/:id' component={KeywordList}></Route>
          <Route path={'/campaigns/keyword/:id'} component={KeywordEdit}></Route>
          <Route path='/campaigns/:id' component={CampaignEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;