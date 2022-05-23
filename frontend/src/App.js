// import logo from './logo.svg';
import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import CampaignEdit from './CampaignEdit';
import CampaignList from './CampaignList';

// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

// export default App;

// class App extends Component {
//   state = {
//     campaigns: []
//   };

//   async componentDidMount() {
//     const response = await fetch('/campaigns');
//     const body = await response.json();
//     this.setState({campaigns: body});
//   }

//   render() {
//     const {campaigns} = this.state;
//     return (
//         <div className="Application">
//           <header className="App-header">
//             <img src={logo} className="App-logo" alt="logo" />
//             <div className="App-intro">
//               <h2>Campaigns</h2>
//               {campaigns.map(campaign =>
//                   <div key={campaign.id}>
//                     Name: {campaign.name} <b></b>
//                     Bid amount: {campaign.bidAmount} <b></b>
//                     Bilance: {campaign.campaignFunds} <b></b>
//                     Status: {campaign.status ? 'on':'off'} <b></b>
//                     Town: {campaign.town} <b></b>
//                     Radius: {campaign.radius} <b></b>
//                     Keywords: {campaign.keywords ? campaign.keywords:"empty"} <b></b>
//                   </div>
//               )}
//             </div>
//           </header>
//         </div>
//     );
//   }
// }
// export default App;

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/campaigns' exact={true} component={CampaignList}/>
          <Route path='/campaigns/:id' component={CampaignEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;