<template>
  <div>
    <div v-if="getDetails===false" style="min-height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>My Employees</h1>
        </div>
        <div class="col-4">
          <b-button size="lg" variant="dark" href="/addEmployee">
            Add Employee
          </b-button>
        </div>
      </div>

      <!-- <div class="page">
        <div class="buttons">
          <a class="btn add-new" href="/booking-form">Add New Booking</a>
        </div>
      </div>
      <h1 style="text-align:center">
        My Bookings
      </h1> -->
      <!-- <BookingList /> -->
      <EmployeeList
        v-for="employee in employees"
        :key="employee.empID"
        :employeeid="employee.empID"
        :emailid="employee.pEmail"
        :fname="employee.fname"
        :lname="employee.lname"
        @clicked="onClickListItem(employee)"
      />
      <!-- <div v-for="booking in bookings" :key="booking.bookingID">
        {{ booking.bookingID }}
      </div> -->
    </div>
    <div v-else>
      <b-button size="lg" variant="dark" @click="goBacktoPage">
        <span>Back</span>
      </b-button>
      <!-- <button class="custom-btn btn-1" @click="goBacktoPage">
        <span>Back</span>
      </button> -->
      <EmployeeDetails :employee="employee" />
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      getDetails: false,
      employees: [],
      employee: {}
    }
  },
  mounted () {
    this.getAllEmployee()
  },
  methods: {
    getAllEmployee () {
      const router = this.$router
      myaxios
        .get(
          '/admin/allEmployee',
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          this.employees = response.data
          console.log(JSON.stringify(this.employees))
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    onClickListItem (value) {
      this.getDetails = true
      this.employee = value
      console.log(this.employee)
    },
    goBacktoPage () {
      this.getAllEmployee()
      this.getDetails = false
    }
  }

}
</script>

<style scoped>
    @import '@/assets/booking/bookingList.css'
</style>
