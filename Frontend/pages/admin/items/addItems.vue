<template>
  <div>
    <div class="container" style="height:100vh">
      <form class="form-container">
        <div class="headline">
          <span>Add Item</span>
        </div>
        <div class="form-line">
          <label style="font-size: 18px; color: darkgrey;">Item Name</label><br><br>
          <input
            v-model="itemName"
            type="text"
            class="form-input"
            autocomplete="off"
            style="cursor: auto;"
            required
          >
        </div>
        <div class="form-line">
          <label style="font-size: 18px; color: darkgrey">Number of Items</label><br><br>
          <input
            v-model="noOfItems"
            type="text"
            class="form-input"
            autocomplete="off"
            style="cursor: auto;"
            required
          >
        </div>
        <div class="form-line">
          <label style="font-size: 18px; color: darkgrey">Price</label><br><br>
          <input
            v-model="price"
            type="Email"
            class="form-input"
            autocomplete="off"
            style="cursor: auto;"
            required
          >
        </div>
        <div class="form-line">
          <label style="font-size: 18px; color: darkgrey">Contact Number</label><br><br>
          <input
            v-model="contactNo"
            type="Email"
            class="form-input"
            autocomplete="off"
            style="cursor: auto;"
            required
          >
        </div>
        <div class="form-line">
          <label style="font-size: 18px; color: darkgrey">Supplier Name</label><br><br>
          <input
            v-model="SupplierName"
            type="form-input"
            class="form-input"
            autocomplete="off"
            style="cursor: auto;"
            required
          >
        </div>

        <input type="button" class="form-button" value="Submit" style="font-size: 18px;" @click="addItem">
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  data () {
    return {
      itemName: '',
      noOfItems: 0,
      price: 0,
      contactNo: '',
      SupplierName: '',
      user: {},
      emp: {}
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
        if (!this.user.isEmp) {
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

    myaxios
      .get(
        '/dashboard/employee',
        {
          headers: {
            // Authorization: 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJMS05GTE4iLCJpYXQiOjE2NjcwNDkwNTQsImV4cCI6MTY2NzA1OTg1NH0.GdsK7YclD7Eeg6UJU2h8femd4FvPe1TOl8zbwm6iNd_gZejtH45Mo1YP8XIzdDrKbVA_7YshzZKHcbr3Dbw_1Q'
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      )
      .then((response) => {
        this.emp = response.data
        if (this.emp.superID == null) {
          this.isAdmin = true
        } else {
          alert('forbidden')
          this.$router.push('/forbidden')
        }
      })
      .catch((error) => {
        this.errorMessage = error.message
        console.error('There was an error!', error)
        alert('An Error has occurred!')
        router.push('/')
      })
  },
  methods: {
    addItem () {
      const router = this.$router
      myaxios
        .post('/admin/addItem', {
          itemName: this.itemName,
          noOfItems: this.noOfItems,
          price: this.price,
          contactNo: this.contactNo,
          supplierName: this.SupplierName
        },
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
        )
        .then(function (response) {
          console.log(response.data)
          router.push('/admin/items')
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
  @import '@/assets/employee/addEmp.css'
</style>
