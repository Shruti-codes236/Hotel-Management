<template>
  <div>
    <div v-if="getDetails===false" style="min-height: 100vh">
      <div class="row justify-content-between" style="text-align:center; margin-top: 40px">
        <div class="col-4">
          <h1>Items List</h1>
        </div>
        <div class="col-4">
          <b-button size="lg" variant="dark" @click="addItems">
            Add Item
          </b-button>
        </div>
      </div>

      <ItemsList
        v-for="item in items"
        :key="item.itemName"
        :itemname="item.itemName"
        :noofitems="item.noOfItems"
        :price="item.price"
        @clicked="onClickListItem(item)"
      />
    </div>
    <div v-else style="min-height: 100vh">
      <b-button size="lg" variant="dark" @click="goBacktoPage">
        <span>Back</span>
      </b-button>
      <ItemDetails :item="item" />
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
      items: [],
      item: {}
    }
  },
  mounted () {
    const router = this.$router
    myaxios
      .get(
        '/admin/items',
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`
          }
        }
      )
      .then((response) => {
        this.items = response.data
        console.log(JSON.stringify(this.items))
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
    onClickListItem (value) {
      this.getDetails = true
      this.item = value
      console.log(this.item)
    },
    goBacktoPage () {
      this.getDetails = false
    },
    addItems () {
      this.$router.push('/admin/items/addItems')
    }
  }

}
</script>

<style scoped>
    @import '@/assets/booking/bookingList.css'
</style>
