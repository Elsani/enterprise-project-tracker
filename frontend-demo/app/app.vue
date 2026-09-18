<template>
  <v-app>
    <v-app-bar color="primary" density="compact">
      <v-app-bar-title>STRABAG Project Dashboard</v-app-bar-title>
    </v-app-bar>

    <v-main>
      <v-container class="mt-6" style="max-width: 900px;">
        <!-- Formulari per shtim projekti -->
        <v-card class="pa-4 mb-6" elevation="2">
          <v-card-title>Shto Projekt të Ri</v-card-title>
          <v-card-text>
            <v-row>
              <v-col cols="12" sm="6">
                <v-text-field v-model="newTitle" label="Titulli i Projektit" variant="outlined" density="compact" />
              </v-col>
              <v-col cols="12" sm="4">
                <v-select v-model="newStatus" :items="['In Progress', 'Completed', 'Planning']" label="Statusi" variant="outlined" density="compact" />
              </v-col>
              <v-col cols="12" sm="2" class="d-flex align-center">
                <v-btn color="success" block @click="addProject">Shto</v-btn>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>

        <!-- Tabela -->
        <v-card elevation="2">
          <v-card-title class="d-flex justify-space-between align-center pa-4">
            <span>Projektet Aktuale (Java Spring Boot + Neon DB)</span>
            <v-btn color="primary" variant="tonal" :loading="loading" @click="fetchProjects">
              Rifresko
            </v-btn>
          </v-card-title>

          <v-table>
            <thead>
              <tr>
                <th class="text-left">ID</th>
                <th class="text-left">Titulli</th>
                <th class="text-left">Statusi</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="item in list" :key="item.id">
                <td>{{ item.id }}</td>
                <td class="font-weight-bold">{{ item.title }}</td>
                <td>
                  <v-chip :color="item.status === 'Completed' ? 'success' : 'primary'" size="small">
                    {{ item.status }}
                  </v-chip>
                </td>
              </tr>
            </tbody>
          </v-table>
          <v-table>
  <thead>
    <tr>
      <th class="text-left">ID</th>
      <th class="text-left">Titulli</th>
      <th class="text-left">Statusi</th>
      <th class="text-right">Veprime</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="item in list" :key="item.id">
      <td>{{ item.id }}</td>
      <td class="font-weight-bold">{{ item.title }}</td>
      <td>
        <v-chip :color="item.status === 'Completed' ? 'success' : 'primary'" size="small">
          {{ item.status }}
        </v-chip>
      </td>
      <td class="text-right">
        <v-btn color="error" size="small" variant="text" @click="deleteProject(item.id)">
          Fshij
        </v-btn>
      </td>
    </tr>
  </tbody>
</v-table>
        </v-card>
      </v-container>
    </v-main>
  </v-app>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const list = ref([])
const loading = ref(false)
const newTitle = ref('')
const newStatus = ref('In Progress')

async function fetchProjects() {
  loading.value = true
  try {
    const data = await $fetch('http://localhost:8080/api/projects')
    list.value = data
  } catch (err) {
    console.error('Gabim:', err)
  } finally {
    loading.value = false
  }
}

async function addProject() {
  if (!newTitle.value) return
  await $fetch('http://localhost:8080/api/projects', {
    method: 'POST',
    body: { title: newTitle.value, status: newStatus.value }
  })
  newTitle.value = ''
  fetchProjects()
}

async function deleteProject(id) {
  try {
    await $fetch(`http://localhost:8080/api/projects/${id}`, {
      method: 'DELETE'
    })
    fetchProjects()
  } catch (err) {
    console.error('Gabim gjatë fshirjes:', err)
  }
}

onMounted(() => {
  fetchProjects()
})
</script>
<style>
@import 'vuetify/styles';
</style>