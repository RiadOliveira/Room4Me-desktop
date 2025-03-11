<h1 align="center">

![Logo png](https://user-images.githubusercontent.com/88398990/156489186-24d246c7-fa32-4793-ae59-e29bc99e09ce.png)

</h1>

<p align="center">
  An application designed to help students find apartments to rent or share with other students. This project has been developed during Java classes at college.
</p>

<h4 align="center">
	:house:&nbsp; Room4Me - Finished &nbsp; :house: </br>
</h4>

![image](https://img.shields.io/github/license/RiadOliveira/Room4Me-desktop)

Contents
=================
<!--ts-->
   * [💡 Proposal](#proposal)
   * [🛠️ Technologies](#technologies)
   * [🗂  Architecture ](#architecture )
   * [:floppy_disk: Entities](#entities)
      * [User](#entity-user)
      * [Address](#entity-address)
      * [Aspects](#entity-aspects)
      * [Apartment](#entity-apartment)
   * [:gear: Features](#features)
   * [:camera: Wireframe](#wireframe)
      * [Login](#login)
      * [SignUp](#sign-up)
      * [Search](#search)
      * [Apartment Details](#apartment-details)
      * [Announce](#announce)
      * [Create Apartment](#create-apartment)
   * [:memo: License](#license)
   * [👨‍💻 Authors](#authors)
<!--te-->
</br>
<h2 id="proposal">💡 Proposal</h2>
<p>
Room4Me is a software developed mainly for university students, as it seeks to make it easier for them to find a place to live during their courses, with the differential of looking for apartments to share with other people (mainly other students). This simplicity can prove to be quite effective, given the difficulty, especially for students from other cities, to locate themselves in places close to their universities and in an economically viable way.
</p>

<h2 id="technologies">🛠️ Technologies</h2>
<p>Tools used on this project:</p>

- [Java](https://www.java.com/)
  - [Java-dotenv](https://jar-download.com/artifact-search/java-dotenv)
  - [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)
  - [JavaFX](https://openjfx.io/)
- [Postgresql](https://www.postgresql.org/)

<h2 id="architecture">🗂 Architecture</h2>
<p>This project uses the MVC (Model-View-Controller) architecture.</p>

<h2 id="entities">:floppy_disk: Entities</h2>

- <h3 id="entity-user">User</h3>

  - id: UUID
  - name: string
  - email: string
  - password: string
  - phone_number: string
  - avatar: string
  - gender: int 

- <h3 id="entity-address">Address</h3>

  - id: UUID
  - city: string
  - district: string
  - street: string
  - complement: string/null
  - apartment_number: string
  - zip_code: integer

- <h3 id="entity-aspects">Aspects</h3>

  - id: UUID
  - bedrooms_quantity: integer
  - available_to_divide: boolean
  - description: string
  - capacity: integer
  - allowed_gender: smallint
  - description: text

- <h3 id="entity-apartment">Apartment</h3>

  - id: UUID
  - <a href="#entity-user">owner</a>: UUID
  - <a href="#entity-address">address</a>: UUID
  - <a href="#entity-aspects">aspects</a>: UUID
  - rent: double
  - image: string

</br>

<h2 id="features">:gear: Features</h2>

- [X] Accounts creation, update and delete. (Using JDBC)
  - Creation: It fills an object in Java, then sends it to the Database.
  - Update: After gets an user (Using find methods from database), updates the object with the new data, then sends it to the Database.
  - Delete: After gets an user (Using find methods from database), sends its ID with delete query to the Database.
- [X] Users can register, update and delete the apartments they own. (Using JDBC)
  - Register: It fills an object in Java, then sends it to the Database.
  - Update: After gets an apartment (Using find methods from database), updates the object with the new data, then sends it to the Database.
  - Delete: After gets an apartment (Using find methods from database), sends its ID with delete query to the Database.
- [X] Users can access contacts details from the owners of the apartments they searched for (When accessing some apartment data, its owner data is also present in the object).
- [X] Search apartments by(And/Or): name, preferences (bedrooms quantity, capacity, allowed gender and/or available to divide), price and location (Whenever a filter is changed, a new query is generated, and all specified apartments are obtained).
- [X] Generate a CSV file containing all apartments (Including their data) searched by the user.

</br>

<h2 id="wireframe">:camera: Wireframe</h2>

- <h3 id="login">Login</h3>
![LOGIN](https://user-images.githubusercontent.com/88398990/158809949-26035b52-fd5a-4706-a3df-8ef2ee0ea901.png)

- <h3 id="sign-up">SignUp</h3>
 ![CADASTRAR](https://user-images.githubusercontent.com/88398990/158810112-74159d52-bf73-4b9e-b991-4606f2abfcc4.png)

- <h3 id="search">Search</h3>
![PROCURAR](https://user-images.githubusercontent.com/88398990/160292004-c5debad7-c1b0-42c0-bc06-481c70850de3.png)


- <h3 id="apartment-details">Apartment Details</h3>
![PROCURAR-MAX](https://user-images.githubusercontent.com/88398990/160292016-f734b579-61c9-4df1-b3bc-e30c99c1d060.png)


- <h3 id="announce">Announce</h3>
![ANUNCIAR](https://user-images.githubusercontent.com/88398990/160292025-526b5c8e-6af0-48bf-b0a4-3bcbd26a0db7.png)


- <h3 id="create-apartment">Create Apartment</h3>

  - #### Address
  ![Cadastrar-1](https://user-images.githubusercontent.com/88398990/158810857-365dd580-365f-4e69-be7d-e0354155cf12.png)
  
  - #### Aspects
   ![Cadastrar-2](https://user-images.githubusercontent.com/88398990/160292032-4fc210cf-42f5-41b4-a9e9-3166e9be4cdc.png)


  - #### Finalization
  ![Cadastrar-3](https://user-images.githubusercontent.com/88398990/158810885-cebbbd4c-601a-4b12-8b32-05bedcb6717d.png)

</br>

<h2 id="license">:memo: License</h2>
This project is MIT Licensed. See <a href="https://github.com/RiadOliveira/Room4Me-desktop/blob/main/LICENSE">LICENSE</a> file for more details.

</br>

<h2 id="authors">👨‍💻 Authors</h2>

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/RiadOliveira">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/69125013?v=4" width="100px;" alt=""/>
        <br /><sub><b>👨‍💻 Ríad Oliveira</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/DaviEmanuelll">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/88398990?v=4" width="100px;" alt=""/>
        <br /><sub><b>👨‍💻 Davi Emanuel</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/isabeleLima">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58983203?v=4" width="100px;" alt=""/>
        <br /><sub><b>👩‍💻 Isabele Cristina</b></sub>
      </a>
    </td>
  </tr>
</table>
