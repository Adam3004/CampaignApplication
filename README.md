# CampaignApplication
Application using to create, edit or delete campaigns for products
## Technologies
* Java 11
* Node.js
* ReactJS
* HTML
* CSS
## Presuppositional
* Campaign fund is a variable in each campaign and means how much money was on Emerald account after paying for that one. 
* Radius may equals 0. It means the campaign is only in the town.
* I decied to set initial Emerald account funds on 10000. It may be changed in CampaignApplication/src/main/java/pl/campaignapplication/session/Session.java
* List of towns is prepared in CampaignApplication/frontend/src/CampaignEdit.js in render. 
## How to run application?
* Open project in intelij (maven dependencies should be downloaded automatically)
* Open console in CampaignApplication folder and use those commands:
```
$ mvn spring-boot:run
$ npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0
```
* Open folder CampaignApplication/frontend and run this command:
```
$ npm start
```
* Window in your browser should be opened automatically after few seconds (Google Chrome prefered)
