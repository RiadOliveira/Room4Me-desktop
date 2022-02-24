<h1 align="center">

![Logo bold](https://user-images.githubusercontent.com/69125013/155432234-8550aa68-6fa0-4973-9ad5-899ad4fdeb04.png)

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
   * [:memo: License](#license)
   * [:wrench: Authors](#authors)
<!--te-->
</br>

<h2 id="technologies">🛠 Technologies</h2>
Tools used on this project:

- [Java](https://www.java.com/)
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
