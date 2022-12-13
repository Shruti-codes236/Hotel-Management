
<template>
  <!-- <div> -->
  <!-- <NavBar /> -->
  <div id="booking" class="section">
    <div class="section-center">
      <div class="container">
        <div v-if="sadaTrue" class="row">
          <div class="booking-form">
            <div class="form-header">
              <h1>Make your reservation</h1>
            </div>
            <form>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <input v-model="checkIn" class="form-control" type="date" required placeholder="Check In Date">
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <input v-model="checkOut" class="form-control" type="date" required placeholder="Check Out Date">
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="fieldLabel">Number of Single Rooms</label>
                    <input
                      v-model="singleOcc"
                      class="form-control"
                      type="number"
                      placeholder="No of Single rooms"
                      required
                    >
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="fieldLabel">Number of Double Rooms</label>
                    <input
                      v-model="doubleOcc"
                      class="form-control"
                      type="number"
                      placeholder="No of Double rooms"
                      required
                    >
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-3" />
                <div class="col-md-6">
                  <div class="form-group">
                    <label class="fieldLabel">Number of Members</label>
                    <input
                      v-model="noOfMembers"
                      class="form-control"
                      type="number"
                      placeholder="No of Members"
                      min="0"
                      required
                    >
                  </div>
                </div>
                <div class="col-md-3" />
              </div>
              <div class="form-btn">
                <button
                  type="button"
                  class="submit-btn"
                  @click="check"
                >
                  Check Availability
                </button>
              </div>
            </form>
          </div>
        </div>
        <div v-if="flag" class="row">
          <div class="booking-form">
            <div class="form-header">
              <h1>Choose Services</h1>
            </div>
            <b-form-checkbox-group
              v-model="selected"
              :options="services"
              class="mb-3"
              value-field="serviceName"
              text-field="serviceName"
              style="color: white; font-size:15px"
            />
          </div>
        </div>

        <div v-if="flag" class="row">
          <div class="booking-form">
            <div v-if="size<noOfMembers" class="form-header">
              <h1>Add Members</h1>
            </div>
            <div v-else class="form-header">
              <h1>All Members added</h1>
            </div>
            <form>
              <div v-if="size<noOfMembers">
                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="fieldLabel">First Name</label>
                      <input v-model="member.fname" class="form-control" type="text" required placeholder="Member First Name">
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="fieldLabel">Last Name</label>
                      <input v-model="member.lname" class="form-control" type="text" required placeholder="Member Last Name">
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="fieldLabel">Age</label>
                      <input
                        v-model="member.age"
                        class="form-control"
                        type="number"
                        placeholder="Age"
                        required
                      >
                    </div>
                  </div>
                  <div class="col-md-6">
                    <div class="form-group">
                      <label class="fieldLabel">Aadhar Number</label>
                      <input
                        v-model="member.aadharNo"
                        class="form-control"
                        type="text"
                        placeholder="Aadhar Number"
                        required
                      >
                    </div>
                  </div>
                </div>
                <div class="form-btn">
                  <button
                    type="button"
                    class="submit-btn"
                    @click="addMember"
                  >
                    Add Member
                  </button>
                </div>
              </div>

              <div class="form-btn">
                <button
                  type="button"
                  class="submit-btn final"
                  @click="bookRoom"
                >
                  Book Room
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- <Footer /> -->
  <!-- </div> -->

  <!-- <a target="_blank" href="https://gosnippets.com" class="white-mode">MORE</a> -->
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
class Member {
  constructor (fname, lname, aadharNo, age) {
    this.fname = fname
    this.lname = lname
    this.aadharNo = aadharNo
    this.age = age
  }
}
export default {
  data () {
    return {
      checkIn: '',
      checkOut: '',
      singleOcc: 0,
      doubleOcc: 0,
      noOfMembers: 0,
      membersList: [

      ],
      member: {
        aadharNo: '',
        age: 0,
        fname: '',
        lname: ''
      },
      flag: false,
      sadaTrue: true,
      size: 0,
      booked: false,
      genBill: {},
      services: [],
      selected: [],
      user: {}
      // numMembers: 0
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('/login')
    }
    const router = this.$router
    myaxios
      .get(
        '/dashboard', // get mapping for all userEmployee subords
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }

      )
      .then((response) => {
        this.user = response.data
        console.log(JSON.stringify(this.user))
        if (this.user.isEmp) {
          alert('forbidden')
          this.$router.push('/forbidden')
        }
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

    correctcheckIn () {
      const date = toString(this.checkIn)
      const day = date.slice(0, 2)
      const month = date.slice(3, 5)
      const year = date.slice(6)
      const x = year + '-' + month + '-' + day
      console.log(x)
    },
    correctcheckOut () {
      const date = toString(this.checkOut)
      const day = date.slice(0, 2)
      const month = date.slice(3, 5)
      const year = date.slice(6)
      const y = year + '-' + month + '-' + day
      console.log(y)
    },
    check () {
      const router = this.$router
      myaxios.post('/booking/check', {
        checkIn: this.checkIn,
        checkOut: this.checkOut,
        singleOcc: this.singleOcc,
        doubleOcc: this.doubleOcc,
        noOfMembers: this.noOfMembers
        // numMembers: this.numMembers
      },
      {
        headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }).then((response) => {
        console.log(response.data)
        this.flag = response.data
        if (this.flag) {
          myaxios
            .get(
              '/booking/services', // get mapping for all userEmployee subords
              {
                headers: {
                  // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
                  Authorization: `Bearer ${localStorage.getItem('token')}`
                }
              }

            )
            .then((response) => {
              this.services = response.data
              console.log(JSON.stringify(this.services))
            }
            )
            .catch((error) => {
              this.errorMessage = error.message
              console.error('There was an error!', error)
              alert('An Error has occurred!')
              router.push('/')
            })
        }
        console.log(this.noOfMembers)

        // if (response.data) { this.$router.push('index') }
      }).catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    },
    addMember () {
      console.log(JSON.stringify(this.member))
      console.log(this.membersList.length)
      const thismember = new Member(this.member.fname, this.member.lname, this.member.aadharNo, this.member.age)
      this.membersList.push(thismember)

      this.size = this.size + 1
      this.member.aadharNo = ''
      this.member.age = 0
      this.member.fname = ''
      this.member.lname = ''
      console.log(JSON.stringify(this.membersList[0]))
    },
    bookRoom () {
      const router = this.$router
      console.log(this.membersList.length)
      console.log(JSON.stringify(this.membersList))
      myaxios.post('/booking/book', {

        checkInDate: this.checkIn,
        checkOutDate: this.checkOut,
        countMember: this.noOfMembers,
        membersList: this.membersList,
        singleRoom: this.singleOcc,
        doubleRoom: this.doubleOcc,
        services: this.selected
        // numMembers: this.numMembers
      },
      {
        headers: {
          // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
          Authorization: `Bearer ${localStorage.getItem('token')}`
        }
      }).then((response) => {
        console.log(JSON.stringify(response.data))
        this.genBill = response.data
        this.booked = true
        this.$router.push({ name: 'bill', params: { genBill: this.genBill } })

        // if (response.data) { this.$router.push('index') }
      }).catch((error) => {
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
    @import '@/assets/booking/booking-form.css';
</style>
