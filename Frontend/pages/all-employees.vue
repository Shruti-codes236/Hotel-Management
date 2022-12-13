<template>
  <div class="container mt-4">
    <div class="text-center darken-grey-text mb-4">
      <h1 class="font-bold mt-4 mb-3 h1">
        <b>Employees</b>
      </h1>
      <br>
    </div>

    <div class="card mb-3">
      <div class="card-body">
        <!--Table-->
        <table class="table table-hover">
          <!--Table head-->
          <thead>
            <tr class="text-white">
              <th>#</th>
              <th>Employee ID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Gender</th>
              <th>Current Address</th>
              <th>Department</th>
            </tr>
          </thead>
          <!--Table head-->
          <!--Table body-->
          <tbody v-for="(emp,index) in employees" :key="emp.empID">
            <tr>
              <th scope="row">
                {{ index+1 }}
              </th>
              <td>
                {{ emp.empID }}
              </td>
              <td>
                {{ emp.fname + emp.lname }}
              </td>
              <td>
                {{ emp.pEmail }}
              </td>
              <td>
                {{ emp.gender }}
              </td>
              <td>
                {{ emp.houseNo + "," + emp.city + "," + emp.state+ "," + emp.Pincode }}
              </td>
              <td>
                {{ emp.deptName }}
              </td>
            </tr>
          </tbody>
          <!--Table body-->
        </table>
        <!--Table-->
        <div>
          <button class="custom-btn btn-1" @click="addEmp">
            <span>Add Employee</span>
          </button>
        </div>
      </div>
    </div>
    <hr class="my-4">
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <br><br>
    <br><br><br><br><br><br><br><br><br><br><br><br>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      employees: []
    }
  },
  mounted () {
    const router = this.$router
    // console.log('mounted')
    myaxios
      .get(
        ''
        // get mapping for all employees
      )
      .then((response) => {
        this.employees = response.data
      }
      )
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
  },
  methods: {
    addEmp () {
      this.$router.push('')
      // adding employee page path
    },
    delEmp () {
      this.$router.push('')
      // deleting employee page path
    }
  }

}
</script>

  <style scoped>
      @import '@/assets/booking/cust_bookings.css';
  </style>
