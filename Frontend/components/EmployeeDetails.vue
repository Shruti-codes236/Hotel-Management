<template>
  <center>
    <div class="col-md-6 col-sm-6 ">
      <div class="chunk booking-card clearfix">
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <span class="profile-pic" />
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9 name-date">
            <div class="guest-name">
              {{ employee.empID }}
            </div>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ employee.fname + " " + employee.lname }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Email ID
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ employee.pEmail }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Current Address
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.currHouseNo + ", " + employee.currCity + ", " + employee.currState }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Permanent Address
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.houseNo + ", " + employee.city + ", " + employee.state + ", " + employee.country }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Salary
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.salary }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Department Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.deptName }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Account Number
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.accountNo }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              IFSC Code
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ employee.ifsccode }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Leaves Taken
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ lTaken }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Leaves Allowed
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ lAll }}
            </span>
          </div>
        </div>
      </div>
      <div style="margin-top:50px">
        <button class="custom-btn btn-1" @click="addLeave">
          <span>Add Leave</span>
        </button>
        <button v-if="leaves.salaryPaid===-1" class="custom-btn btn-1" @click="markAsPaid">
          <span>Mark as Paid</span>
        </button>
        <button v-if="leaves.salaryPaid!=-1" class="custom-btn btn-disabled">
          <span>Paid</span>
        </button>
        <button class="custom-btn btn-1" @click="deleteEmployee">
          <span>Delete Employee</span>
        </button>
      </div>
    </div>
  </center>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  props: ['employee'],
  data () {
    return {
      leaves: {},
      lTaken: 0,
      lAll: 0
    }
  },
  mounted () {
    this.getLeaves()
    console.log('mounted')
  },
  methods: {
    getLeaves () {
      const router = this.$router
      myaxios
        .post(
          '/admin/getLeavesSalaries',
          {
            empID: this.employee.empID,
            userID: this.employee.userID
          },
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          this.leaves = response.data
          this.lTaken = this.leaves.leavesTaken
          this.lAll = this.leaves.leavesAllowed
          console.log(JSON.stringify(this.leaves))
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    addLeave () {
      const router = this.$router
      myaxios
        .post(
          '/admin/addLeave',
          {
            empID: this.employee.empID,
            leavesTaken: this.leaves.leavesTaken,
            leavesAllowed: this.leaves.leavesAllowed,
            salaryPaid: this.leaves.salaryPaid,
            month: this.leaves.month,
            year: this.leaves.year

          },
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          this.leaves = response.data
          this.lTaken = this.leaves.leavesTaken
          this.lAll = this.leaves.leavesAllowed
          console.log(JSON.stringify(this.leaves))
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    deleteEmployee () {
      const router = this.$router
      myaxios
        .post(
          '/admin/deleteEmployee',
          {
            userID: this.employee.userID,
            fname: this.employee.fname,
            lname: this.employee.lname,
            pEmail: this.employee.pEmail,
            pswd: this.employee.pswd,
            houseNo: this.employee.houseNo,
            city: this.employee.city,
            state: this.employee.state,
            country: this.employee.country,
            pinCode: this.employee.pinCode,
            gender: this.employee.gender,
            isEmp: true

          },
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          console.log(response.data)
          router.push('/admin')
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    },
    markAsPaid () {
      const router = this.$router
      myaxios
        .post(
          '/admin/paySalary',
          {
            salaryPaid: this.leaves.salaryPaid,
            empID: this.leaves.empID,
            month: this.leaves.month,
            year: this.leaves.year,
            leavesAllowed: this.leaves.leavesAllowed,
            leavesTaken: this.leaves.leavesTaken
          },
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem('token')}`
            }
          }

        )
        .then((response) => {
          this.leaves = response.data
          console.log(JSON.stringify(this.leaves))
        }
        )
        .catch((error) => {
          this.errorMessage = error.message
          console.error('There was an error!', error)
          alert('An Error has occurred!')
          router.push('/')
        })
    }
  }

}
</script>

<style scoped>
@import "@/assets/booking/bookingDetails.css";
@import "@/assets/booking/bookingList.css"
</style>
