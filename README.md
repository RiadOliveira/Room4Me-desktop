<h1 align="center">

![Logo png](https://user-images.githubusercontent.com/88398990/156489186-24d246c7-fa32-4793-ae59-e29bc99e09ce.png)

</h1>

<p align="center">
  An application designed to help students find apartments to rent or divide with other students. This project has been developed during Java classes at college.
</p>

<h4 align="center">
	:house:&nbsp; Room4Me - In development... &nbsp; :house: </br>
</h4>

![image](https://img.shields.io/github/license/RiadOliveira/Room4Me)

Contents
=================
<!--ts-->
   * [🛠 Technologies](#technologies)
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
   * [:wrench: Authors](#authors)
<!--te-->
</br>

<h2 id="technologies">🛠 Technologies</h2>
Tools used on this project:

- [Java](https://www.java.com/)
  - [Java-dotenv](https://jar-download.com/artifact-search/java-dotenv)
  - [PostgreSQL JDBC Driver](https://jdbc.postgresql.org/download.html)
  - [JavaFX](https://openjfx.io/)
- [Postgresql](https://www.postgresql.org/) </br></br>

<h2 id="entities">:floppy_disk: Entities</h2>

- <h3 id="entity-user">User</h3>

  - id: UUID
  - name: string
  - email: string
  - password: string
  - phone_number: string
  - avatar: string/null (name of the file)
  - type: boolean (0: renter, 1: owner)

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

- <h3 id="entity-apartment">Apartment</h3>

  - id: UUID
  - <a href="#entity-user">owner</a>: UUID
  - <a href="#entity-address">address</a>: UUID
  - <a href="#entity-aspects">aspects</a>: UUID
  - rent: double
  - image: string/null (name of the file)

</br>

<h2 id="features">:gear: Features</h2>

- [ ] Accounts creation (As owner or renter), update and delete.
- [ ] Change account type(owner to renter or renter to owner).
- [ ] (Owner) Register, update and delete apartments.
- [ ] (Renter) Can contact the apartment owner. 
- [ ] Search apartments by(And/Or): name, preferences (bedrooms quantity, capacity ...), price and location.

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
This project is MIT Licensed. See <a href="https://github.com/RiadOliveira/Room4Me/blob/main/LICENSE">LICENSE</a> file for more details.

</br>

<h2 id="authors">:wrench: Authors</h2>

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/RiadOliveira">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/69125013?v=4" width="100px;" alt=""/>
        <br /><sub><b>Ríad Oliveira</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/DaviEmanuelll">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/88398990?v=4" width="100px;" alt=""/>
        <br /><sub><b>Davi Emanuel</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/isabeleLima">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/58983203?v=4" width="100px;" alt=""/>
        <br /><sub><b>Isabele Cristina</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/HugoGomes35">
        <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/88948975?v=4" width="100px;" alt=""/>
        <br /><sub><b>Hugo Gomes</b></sub>
      </a>
    </td>
  </tr>
</table>
