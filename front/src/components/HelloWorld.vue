<template>
  <v-container>
    <v-layout
      text-xs-center
      wrap
    >
      <v-flex xs12>
        <v-card>
          <v-card-title>
            Prénoms
            <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          append-icon="fas fa-search"
          label="Search"
          single-line
          hide-details/>
          </v-card-title>
        <v-data-table
           v-if="firstNames"
          :headers="headers"
          :items="firstNames"
          :pagination.sync="pagination"
          :total-items="totalElements"
          :loading="loading"
          :search="search">
          <template slot="items" slot-scope="props">
            <td>{{ props.item.sex }}</td>
            <td>{{ props.item.firstLetter }}</td>
            <td>{{ props.item.firstName }}</td>
            <td>{{ props.item.decade }}</td>
            <td>{{ props.item.birthYear }}</td>
            <td>{{ props.item.department }}</td>
            <td>{{ props.item.count }}</td>
          </template>
        </v-data-table>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'

  export default {
    data: () => ({
      headers: [
        { text: 'Sexe', value: 'sex' },
        { text: 'Initiale', value: 'firstLetter', sortable: false },
        { text: 'Prénom', value: 'firstName' },
        { text: 'Décennie', value: 'decade', sortable: false },
        { text: 'Année de naissance', value: 'birthYear' },
        { text: 'Département', value: 'department' },
        { text: 'Nombre', value: 'count' },
      ],
      pagination: {},
      search: '',
    }),
    asyncComputed: {
      async firstNames () {
        if (this.search) {
          return this.findFirstName({ search: this.search, pagination: this.pagination })
        }
        return this.loadFirstNames(this.pagination)
      }
    },
    computed: {
      ...mapState(['loading', 'totalElements'])
    },
    methods: {
      ...mapActions(['findFirstName', 'loadFirstNames'])
    }
  }
</script>

<style>

</style>
