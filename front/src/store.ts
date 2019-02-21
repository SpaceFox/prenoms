import axios from 'axios';
import qs from 'qs';
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    content: [],
    empty: true,
    first: true,
    last: false,
    number: 0,
    numberOfElements: 20,
    pageable: {},
    size: 20,
    sort: {},
    totalElements: 0,
    totalPages: 0,
    loading: false,
  },
  mutations: {
    setLoading(state, loading) {
      state.loading = loading;
    },
    updateData(state, data) {
      state.content = data.content;
      state.empty = data.empty;
      state.first = data.first;
      state.last = data.last;
      state.number = data.number;
      state.numberOfElements = data.numberOfElements;
      state.pageable = data.pageable;
      state.size = data.size;
      state.sort = data.sort;
      state.totalElements = data.totalElements;
      state.totalPages = data.totalPages;
    },
  },
  actions: {
    async findFirstName({ commit, state }, { search, pagination: { descending, page, rowsPerPage, sortBy } }) {
      commit('setLoading', true);
      try {
        const query: { page: any, size: any, sort?: string } = { page, size: rowsPerPage };
        if (sortBy) {
          query.sort = `${sortBy},${descending ? 'desc' : 'asc'}`;
        }
        const response = await axios.get(`http://localhost:8080/firstName/${search}?${qs.stringify(query)}`);
        commit('updateData', response.data);
        return state.content;
      } catch (error) {
        console.warn(error);
      } finally {
        commit('setLoading', false);
      }
    },
    async loadFirstNames({ commit, state }, { descending, page, rowsPerPage, sortBy }) {
      commit('setLoading', true);
      try {
        const query: { page: any, size: any, sort?: string } = { page, size: rowsPerPage };
        if (sortBy) {
          query.sort = `${sortBy},${descending ? 'desc' : 'asc'}`;
        }
        const response = await axios.get(`http://localhost:8080/firstNames?${qs.stringify(query)}`);
        commit('updateData', response.data);
        return state.content;
      } catch (error) {
        console.warn(error);
      } finally {
        commit('setLoading', false);
      }
    },
  },
});
