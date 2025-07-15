<h1 align="center">

![image](https://user-images.githubusercontent.com/88398990/156489186-24d246c7-fa32-4793-ae59-e29bc99e09ce.png)

</h1>

<p align="center">
  Room4Me is a apartment rental and sharing platform designed specifically for university students. Developed during Java programming courses at college, it provides a complete digital solution for students seeking affordable housing options and roommate connections.
</p>

![image](https://github.com/user-attachments/assets/aa25a607-2748-409c-9077-5ba38c1d216b)
![image](https://img.shields.io/github/license/RiadOliveira/Room4Me)

<br/>

Contents
=================
<!--ts-->
* [💡 Project Overview](#overview)
* [🛠️ Technologies](#technologies)
* [🚀 Getting Started](#getting-started)
	* [Prerequisites](#prerequisites)
	* [Installation & Setup](#setup)
* [⚙️ Features](#features)
* [🗃️ Database Entities](#entities)
	* [User](#entity-user)
	* [Address](#entity-address)
	* [Aspects](#entity-aspects)
	* [Apartment](#entity-apartment)
* [🏗️ Architecture](#architecture)
* [📷 Application Screenshots](#screenshots)
	* [Authentication](#login)
	* [User Registration](#sign-up)
	* [Apartment Search](#search)
	* [Apartment Details](#apartment-details)
	* [Property Management](#announce)
	* [Apartment Registration](#create-apartment)
 		* [Address Information](#create-address)
		* [Property Aspects](#create-aspects)
		* [Registration Finalization](#create-finalization) 
* [📝 License](#license)
* [👨‍💻 Authors](#authors)
<!--te-->
<br/>

<h2 id="overview">💡 Project Overview</h2>

Room4Me addresses the critical housing challenges faced by university students, particularly those studying away from home. The platform simplifies the process of finding affordable accommodation and connecting with potential roommates, creating a supportive community for student housing needs. With its user-friendly interface and comprehensive search capabilities, Room4Me bridges the gap between students seeking housing and those offering shared living spaces.<br/><br/>

<h2 id="technologies">🛠️ Technologies</h2>
Built with:

* [Java JDK 21](https://www.java.com/)
	* [JavaFX SDK (17.0.0.1)](https://openjfx.io/)
	* [PostgreSQL JDBC (42.2.23)](https://jdbc.postgresql.org/)
	* [Java-dotenv (3.2.0)](https://github.com/cdimascio/dotenv-java)
* [PostgreSQL](https://www.postgresql.org/) <br/><br/>

<h2 id="getting-started">🚀 Getting Started</h2>

<h3 id="prerequisites">Prerequisites</h3>

Before running the application, ensure the following tools are installed on your system:
* [Git](https://git-scm.com)
* [Java JDK 21](https://www.java.com/)
* [PostgreSQL](https://www.postgresql.org/)

**Note**: Project dependencies (JavaFX, PostgreSQL driver, and Java-dotenv) are already included in the project structure.

<h3 id="setup">Installation & Setup</h3>

```bash
# Clone the repository
$ git clone https://github.com/RiadOliveira/Room4Me.git

# Navigate to project directory
$ cd Room4Me

# Environment Configuration
# Create and configure your .env file with database password
$ cp .env.example .env

# Configure your PostgreSQL database password in the .env file
# Update the following variable:
# DATABASE_PASSWORD=your_postgres_password

# Create the database in PostgreSQL
# Connect to PostgreSQL and create the database:
# CREATE DATABASE Room4ME;

# Compile the application and copy FXML views to the bin directory
javac --module-path lib/javafx-sdk-* --add-modules javafx.controls,javafx.fxml -cp "lib/*:lib/javafx-sdk-*/*" -d bin $(find src -name "*.java") && cp -r src/view/images src/view/screens bin/view/

# Run the application
java --module-path lib/javafx-sdk-* --add-modules javafx.controls,javafx.fxml -cp "bin:lib/*:lib/javafx-sdk-*/*" view.MainScreen
```

<br/>

<h2 id="features">⚙️ Features</h2>

- **Complete User Management** - Full account lifecycle including registration, profile updates, and secure authentication with password encryption.
- **Advanced Search System** - Multi-criteria apartment search with filters for location, price range, bedroom quantity, capacity, gender preferences, and sharing availability.
- **Property Management** - Comprehensive CRUD operations for apartment listings with detailed information management and image handling.
- **Contact Integration** - Direct access to property owner contact information for seamless communication between students.
- **Data Export Capabilities** - Generate CSV reports containing all searched apartments with complete property details for offline analysis.
- **Gender-Based Filtering** - Specialized search options to accommodate gender-specific housing preferences and requirements.
- **Sharing Options** - Dedicated features for students looking to share apartments with roommates or find individual accommodations. <br/><br/>

<h2 id="entities">🗃️ Database Entities</h2>

<h3 id="entity-user">User</h3>

- **id**: UUID
- **name**: string
- **email**: string
- **password**: string
- **phone_number**: string
- **avatar**: string - Profile picture filename
- **gender**: integer - Gender identifier (0: Male, 1: Female, 2: Other)

<h3 id="entity-address">Address</h3>

- **id**: UUID
- **city**: string
- **district**: string
- **street**: string
- **complement**: string/null
- **apartment_number**: string
- **zip_code**: integer

<h3 id="entity-aspects">Aspects</h3>

- **id**: UUID
- **bedrooms_quantity**: integer
- **available_to_divide**: boolean
- **description**: text
- **capacity**: integer
- **allowed_gender**: smallint - Gender restrictions (0: Male only, 1: Female only, 2: Mixed)

<h3 id="entity-apartment">Apartment</h3>

- **id**: UUID
- **owner**: UUID
- **address**: UUID
- **aspects**: UUID
- **rent**: double
- **image**: string

<br/>

<h2 id="architecture">🏗️ Architecture</h2>

Room4Me follows the **Model-View-Controller (MVC)** architectural pattern, ensuring clean separation of concerns and maintainable code structure. The application leverages JavaFX for the presentation layer, JDBC for data persistence, and implements robust business logic through well-defined service layers.

<br/>

<h2 id="screenshots">📷 Application Screenshots</h2>

<h3 id="login">Authentication</h3>

![image](https://user-images.githubusercontent.com/88398990/158809949-26035b52-fd5a-4706-a3df-8ef2ee0ea901.png)

<h3 id="sign-up">User Registration</h3>

![image](https://user-images.githubusercontent.com/88398990/158810112-74159d52-bf73-4b9e-b991-4606f2abfcc4.png)

<h3 id="search">Apartment Search</h3>

![image](https://user-images.githubusercontent.com/88398990/160292004-c5debad7-c1b0-42c0-bc06-481c70850de3.png)

<h3 id="apartment-details">Apartment Details</h3>

![image](https://user-images.githubusercontent.com/88398990/160292016-f734b579-61c9-4df1-b3bc-e30c99c1d060.png)

<h3 id="announce">Property Management</h3>

![image](https://user-images.githubusercontent.com/88398990/160292025-526b5c8e-6af0-48bf-b0a4-3bcbd26a0db7.png)

<h3 id="create-apartment">Apartment Registration</h3>

- <h4 id="create-address">Address Information</h4>

![image](https://user-images.githubusercontent.com/88398990/158810857-365dd580-365f-4e69-be7d-e0354155cf12.png)

- <h4 id="create-aspects">Property Aspects</h4>

![image](https://user-images.githubusercontent.com/88398990/160292032-4fc210cf-42f5-41b4-a9e9-3166e9be4cdc.png)

- <h4 id="create-finalization">Registration Finalization</h4>

![image](https://user-images.githubusercontent.com/88398990/158810885-cebbbd4c-601a-4b12-8b32-05bedcb6717d.png)

<h2 id="license">📝 License</h2>
This project is MIT Licensed. See <a href="https://github.com/RiadOliveira/Room4Me/blob/main/LICENSE">LICENSE</a> file for more details.

<br/>

<h2 id="authors">👨‍💻 Authors</h2>

<kbd>
 <a href="https://github.com/RiadOliveira">
   <img src="https://avatars.githubusercontent.com/u/69125013?v=4" width="100" alt="Ríad Oliveira"/>
   <br/><br/>
   <p align="center"><b>Ríad Oliveira</b></p>
 </a>
</kbd>
<kbd>
 <a href="https://github.com/DaviEmanuelll">
   <img src="https://avatars.githubusercontent.com/u/88398990?v=4" width="100" alt="Davi Emanuel"/>
   <br/><br/>
   <p align="center"><b>Davi Emanuel</b></p>
 </a>
</kbd>
<kbd>
 <a href="https://github.com/isabeleLima">
   <img src="https://avatars.githubusercontent.com/u/58983203?v=4" width="100" alt="Isabele Cristina"/>
   <br/><br/>
   <p align="center"><b>Isabele Cristina</b></p>
 </a>
</kbd>
