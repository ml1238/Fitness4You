
# Initial Requirements <br />

## 1. Introduction <br /> 

### 1.1 Purpose of Product <br />
&nbsp; The purpose of our project is to give people a way to compare their statistics, in terms of physical activity, to their peers. We chose this idea because we believe that it would allow for comradery between friends, classmates, or even strangers. Through our website our users can choose to share their data with others, or simply get the statistics of their own workout. <br />

### 1.2 Scope of Produt <br />
&nbsp; The scope of our product is to create a program that will connect University students, in this case the students of NMSU, that will allow for greater connections in terms of fitness and activity. Although this idea would have been great during the summer of 2016 (Pokemon Go), the purpose that it can serve today is still useful. Once this product is launched there is possibility that it can stem to other universities to create a better sense of community amongst students. <br />

### 1.3 Acronyms, Abbreviations, Definitions <br />
&nbsp; BDC: Burn Down Chart <br />

### 1.4 References <br />
&nbsp; [Python Django Tutorials](https://www.youtube.com/watch?v=Z4D3M-NSN58&list=PLzMcBGfZo4-kQkZp-j9PNyKq7Yw5VYjq9&index=3) <br />
&nbsp; [Amazon EC2 Instance Types (Recommended by Dr. Hamilton & Dr. Toups](https://aws.amazon.com/ec2/instance-types/) < br />

## 2. General Description of Product  <br />

### 2.1 Context of Product <br />
&nbsp; Our product will be used through a web interace. Preferrably through a PC, but this will work through a phone, the user will be able to navigate to our website and upload an XML document that contains their health statistics that has not yet been parsed and organized. <br />

### 2.2 Domain Model with Description <br />
&nbsp; Our domain model is relatively simple as it is not fully fleshed out, as of right now our domain model goes as follows. A university, NMSU, has a community that uses our website. Our website is programmed by our members and has user interaction through the users uploading their health statistics where they can interact with their community and in turn their university. <br />
![Fitness4U DomainModel](https://user-images.githubusercontent.com/98048589/160038506-a1732d24-5002-4709-af86-bb94f66c7df6.png) <br />

### 2.3 Product Functions (general) <br />
&nbsp; Our product is a website that can be accessed by anyone anywhere. Visitors can create accounts and after signing up they can upload their health statistics, where we then analyze their data and present it back to them in a way that is easy to understand and conceptualize. With user consent, we are able to display the data of all participating users on public leaderboards. These leaderboards have many different categories. <br />

### 2.4 User Characteristics and Expectations <br />
&nbsp; Our users will be students, faculty, or other poeple who happen to find our website. Their abilities include creating accounts, uploading their health statistics, and changing their place on the leaderboard by getting more active. <br />

### 2.5 Constraints <br />
&nbsp; The constraints on our system is that we can only handle a certain number of users on our website and our leaderboards. We plan to make the leaderboard list a top 15, with another category that shows the current user's specific spot on that leaderboard, however this is not a concrete plan. A larger constraint is that our program and website is specific to Apple device users, as their health app is the only app that we have programmed to read output from. With this being said we may plan to include Android users, however there is no current agenda to do so. <br />

### 2.6 Assumptions and Dependencies <br />
&nbsp; Our system depends on Amazon's EC2 offering and the Django software package in Pyython. The major assumption of our program is that our users will be Apple users who upload the specific Health Statistic XML file available in all Apple user's health app. <br />

## 3. Functional Requirements <br />

&nbsp; [User Stories] (https://github.com/ml1238/Fitness4You/blob/gh-pages/userstories.md) <br />

## 4. System and Non-functional Requirements <br />

### 4.1 External Interface Requirements (User, Hardware, Software, Communications) <br />
&nbsp; Our product uses a website interace and has two requirements <br />
&nbsp; NF.4.1.1 Amazon's EC2 Program <br />
&nbsp; NF.4.1.2 Python's Django Program <br />

### 4.2 Performance Requirements <br />
&nbsp; Our product's performance needs are reliant on Amazon's EC2 program and will be ran through their servers. <br />
&nbsp; NF.4.2.1 Amazon's EC2 Program <br />

### 4.3 Design Constraints <br />
&nbsp; External requirements that constrain our design choices are time and resources. <br />
&nbsp; NF.4.3.1 Time and Resources <br />

### 4.4 Quality Requirements <br />
&nbsp; Our user's quality expectations are that the website is easy to navigate and looks decent. Our system is not life crticial, and the issues we face are <br />
&nbsp; NF.4.4.1 Importing User Data
&nbsp; NF.4.4.2 Implementing Compatability for Android Users

### 4.5 Other Requirements <br />
&nbsp; As of right now there are no other requirements. <br />

## 5. Appendices <br />

&nbsp; [User Stories](https://github.com/ml1238/Fitness4You/blob/gh-pages/userstories.md) <br />
&nbsp; [Python Django Tutorials](https://www.youtube.com/watch?v=Z4D3M-NSN58&list=PLzMcBGfZo4-kQkZp-j9PNyKq7Yw5VYjq9&index=3) <br />
&nbsp; [Amazon EC2 Instance Types (Recommended by Dr. Hamilton & Dr. Toups](https://aws.amazon.com/ec2/instance-types/) < br />







