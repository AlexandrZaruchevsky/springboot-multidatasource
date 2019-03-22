
var findSPU = Vue.resource('/getFIOFromSPU{/sn}');

Vue.component('my-frame',{
    props:['message'],
    data: function () {
        return {
            sn: '',
            sn_:'',
            person:{
                sn:'',
                kch:'',
                fm:'',
                im:'',
                ot:'',
                dtr:'',
                pol:''
            }
        }
    },
    template:
        '<div class="mt-5">' +
            '<h1>Message</h1>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" id="snils7" placeholder="___.___.___ __" aria-describedby="button-addon2" v-model="sn">' +
                '<div class="input-group-append">' +
                    '<input class="btn btn-outline-secondary" type="button" id="button-addon2" value="Search" @click="search"/>' +
                '</div>' +
            '</div>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" placeholder="Фамилия" v-model="person.fm" />' +
            '</div>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" placeholder="Имя" v-model="person.im" />' +
            '</div>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" placeholder="Отчество"  v-model="person.ot" />' +
            '</div>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" placeholder="__.__.____" id="birth-date" v-model="person.dtr" />' +
            '</div>' +
            '<div class="input-group mb-3">' +
                '<input type="text" class="form-control" placeholder="Пол" v-model="person.pol" />' +
            '</div>' +
        '</div>',
    computed:{
        sn_f:function(){
            return this.sn.substr(0,3) + this.sn.substr(4,3) + this.sn.substr(8,3)
        }
    },
    methods:{
        search:function () {
            console.log(this.sn_f);
            findSPU.get({sn: this.sn_f}).then(result => {
                if(result.status === 200){
                    result.json().then(data => {
                        this.person.fm = data.fm;
                        this.person.im = data.im;
                        this.person.ot = data.ot;
                        this.person.dtr = data.dtrStr;
                        this.person.pol = data.pol;
                    })
                }},error=> {
                    this.person.fm = '';
                    this.person.im = '';
                    this.person.ot = '';
                    this.person.dtr = '';
                    this.person.pol = '';
                });

            }
    }
});

var app = new Vue({
    el: '#app',
    data: function () {
        return{
            message: ''
        }
    },
    template:
        '<div class="container col-4">' +
            '<my-frame />' +
        '</div>'
});