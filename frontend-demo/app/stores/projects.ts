import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useProjectStore = defineStore('projects', () => {
  const list = ref<any[]>([])
  const loading = ref(false)

  async function fetchProjects() {
    loading.value = true
    try {
      const data = await $fetch<any[]>('http://localhost:8080/api/projects')
      list.value = data
    } catch (err) {
      console.error('Gabim gjatë marrjes së projekteve:', err)
    } finally {
      loading.value = false
    }
  }

  return { list, loading, fetchProjects }
})