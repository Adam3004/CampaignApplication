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
* I decied to set initial Emerald account funds on 10000. It may be changed in CampaignApplication/src/main/java/pl/campaignapplication/service/CampaignService.java
* List of towns is prepared in CampaignApplication/frontend/src/CampaignEdit.js in render.
* If we edit or delete bid amount our bilance will be automatically changed (unless refresh site). 
## How to run application?
* Open project in intelij (maven dependencies should be downloaded automatically unless do it manually by putting the button) (probably not necessary step)
* Open console in CampaignApplication folder and use this command:
```
$ mvn spring-boot:run
```
* Open console in folder CampaignApplication/frontend and run those commands:
```
$ npm install --save bootstrap@5.1 react-cookie@4.1.1 react-router-dom@5.3.0 reactstrap@8.10.0
$ npm start
```
* Window in your browser should be opened automatically after few seconds (Google Chrome prefered)
