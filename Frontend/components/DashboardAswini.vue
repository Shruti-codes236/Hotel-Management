<template>
  <div class="container emp-profile">
    <form method="post">
      <div class="row">
        <div class="col-md-4">
          <div class="profile-img">
            <!-- <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""> -->
            <img src="@/static/imgs/360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg" alt="">
            <!-- <div class="file btn btn-lg btn-primary">
              Change Photo
              <input type="file" name="file">
            </div> -->
          </div>
        </div>
        <div class="col-md-6">
          <div class="profile-head">
            <h5>
              {{ user.fname + " " + user.lname }}
            </h5>
            <ul id="myTab" class="nav nav-tabs" role="tablist">
              <li class="nav-item">
                <a
                  id="home-tab"
                  class="nav-link active"
                  data-toggle="tab"
                  href="#home"
                  role="tab"
                  aria-controls="home"
                  aria-selected="true"
                >About</a>
              </li>
              <!-- <li class="nav-item">
                <a
                  id="profile-tab"
                  class="nav-link"
                  data-toggle="tab"
                  href="#profile"
                  role="tab"
                  aria-controls="profile"
                  aria-selected="false"
                >Timeline</a>
              </li> -->
            </ul>
          </div>
        </div>
        <div class="col-md-2">
          <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile">
        </div>
      </div>
      <div class="row">
        <div class="col-md-4">
          <div class="profile-work">
            <p>Options</p>
            <button type="button" class="btn btn-primary btn-block">
              Primary
            </button>
            <button type="button" class="btn btn-primary btn-block">
              Primary
            </button>
          </div>
        </div>
        <div class="col-md-8">
          <div id="myTabContent" class="tab-content profile-tab">
            <div class="tab-pane fade show active" role="tabpanel" aria-labelledby="home-tab">
              <!-- <div class="row">
                <div class="col-md-6">
                  <label>User Id</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.userID }}</p>
                </div>
              </div> -->
              <div class="row">
                <div class="col-md-6">
                  <label>Name</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.fname + " " + user.lname }} </p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Email</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.pEmail }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Address</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.houseNo + ", "+ user.city + ", " + user.state }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Country</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.country }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Pin Code</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.pinCode }}</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Gender</label>
                </div>
                <div class="col-md-6">
                  <p>{{ user.gender }}</p>
                </div>
              </div>
            </div>
            <!-- <div id="profile" class="tab-pane fade" role="tabpanel" aria-labelledby="profile-tab">
              <div class="row">
                <div class="col-md-6">
                  <label>Experience</label>
                </div>
                <div class="col-md-6">
                  <p>Expert</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Hourly Rate</label>
                </div>
                <div class="col-md-6">
                  <p>10$/hr</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Total Projects</label>
                </div>
                <div class="col-md-6">
                  <p>230</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>English Level</label>
                </div>
                <div class="col-md-6">
                  <p>Expert</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-6">
                  <label>Availability</label>
                </div>
                <div class="col-md-6">
                  <p>6 months</p>
                </div>
              </div>
              <div class="row">
                <div class="col-md-12">
                  <label>Your Bio</label><br>
                  <p>Your detail description</p>
                </div>
              </div>
            </div> -->
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      user: {}
    }
  },
  mounted () {
    // console.log('mounted')
    console.log(localStorage.getItem('token'))
    const router = this.$router
    myaxios
      .get(
        '/dashboard',
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      )
      .then(response => (
        this.user = response.data
        // console.log(response.data)
      ))
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
    console.log(this.user)
  }
}
</script>

<style scoped>
  @import '@/assets/profile/profile.css';
</style>
