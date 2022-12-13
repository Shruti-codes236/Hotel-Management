<template>
  <div>
    <NavBar />
    <AllContactUs :customerid="customerID" />
    <Footer />
  </div>
</template>

<script>
export default {
  data () {
    return {
      customerID: ''
    }
  },
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('/login')
    }
  },
  created () {
    this.customerID = this.$route.params.customerid
    console.log(this.customerID)
  }
}
</script>
