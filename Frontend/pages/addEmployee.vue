<template>
  <div>
    <NavBar />
    <OldAddEmployee />
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

<style>
</style>
