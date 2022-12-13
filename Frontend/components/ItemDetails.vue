<template>
  <center style="min-height: 69vh">
    <div class="col-md-6 col-sm-6">
      <div class="chunk booking-card clearfix">
        <div class="row">
          <div class="col-md-3 col-sm-3 col-xs-3">
            <span class="profile-pic" />
          </div>
          <div class="col-md-9 col-sm-9 col-xs-9 name-date">
            <div class="guest-name">
              Item Details
            </div>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-in">
              Item Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-in-date">
              {{ item.itemName }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="check-out">
              Number Of Items
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="check-out-date">
              {{ item.noOfItems }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Item Price
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ item.price }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Contact No
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ item.contactNo }}
            </span>
          </div>
        </div>
        <div class="row card-row">
          <div class="col-md-3 col-sm-3 col-xs-4 card-catergory">
            <span class="Details">
              Supplier Name
            </span>
          </div>
          <div class="col-md-9 col-sm-9 col-xs-8 card-data">
            <span class="nights">
              {{ item.supplierName }}
            </span>
          </div>
        </div>
      </div>
      <div style="margin-top:50px">
        <button class="custom-btn btn-1" @click="deleteItem">
          <span>Recieved Item</span>
        </button>
      </div>
    </div>
  </center>
</template>

<script>
import axios from 'axios'
const myaxios = axios.create({ baseURL: 'https://lelotusgrand.herokuapp.com' })
export default {
  props: ['item'],
  mounted () {
    console.log(JSON.stringify(this.item))
    // getmapping for the passed bookingID
  },
  methods: {
    deleteItem () {
      const router = this.$router
      myaxios
        .post('/admin/deleteItem', {
          itemName: this.item.itemName
        },
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
        ).then(function (response) {
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
    }
  }
}
</script>

<style scoped>
@import "@/assets/booking/bookingDetails.css"
</style>
