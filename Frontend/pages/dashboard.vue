<template>
  <div>
    <NavBar />
    <DashboardGargi />
    <Footer />
  </div>
</template>

<script>
export default {
  mounted () {
    const tkn = localStorage.getItem('token')
    if (tkn === null) {
      alert('User not logged in')
      this.$router.push('/login')
    }
  }
}
</script>
