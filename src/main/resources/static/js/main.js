var mainApi = Vue.resource('/products');

Vue.component('product-form', {
    props: ['products'],
    data() {
        return {
            productType: '',
            productName: '',
            productBrand: '',
            productSize: '',
            productSwitch: '',
            productColours: '',
            productLayout: '',
            productFeedback: '',
            productPretravel: '',
            productPrice: '',
            productImage: ''
        }
    },
    template: '<div> ' +
        '<label>Product Type:</label> ' +
        '<input type="checkbox" v-model="productType" value="Keyboard"> Keyboard ' +
        '<input type="checkbox" v-model="productType" value="Keycap"> Keycap ' +
        '<input type="checkbox" v-model="productType" value="Switch"> Switch' +
        ' <div v-if="productType === Keyboard"> ' +
        '<label>Product Name:</label> <input type="text" v-model="productName"> ' +
        '<label>Product Brand:</label> <input type="text" v-model="productBrand"> ' +
        '<label>Product Size:</label> <input type="text" v-model="productSize"> ' +
        '<label>Product Switch:</label> <input type="text" v-model="productSwitch"> ' +
        '<label>Product Colours:</label> <input type="text" v-model="productColours"> ' +
        '<label>Product Price:</label> <input type="text" v-model="productPrice"> ' +
        '<label>Product Image:</label> <input type="text" v-model="productImage"> </div> ' +
        '<div v-if="productType === Keycap"> ' +
        '<label>Product Name:</label> <input type="text" v-model="productName"> ' +
        '<label>Product Brand:</label> <input type="text" v-model="productBrand"> ' +
        '<label>Product Layout:</label> <input type="text" v-model="productLayout"> ' +
        '<label>Product Colours:</label> <input type="text" v-model="productColours"> ' +
        '<label>Product Price:</label> <input type="text" v-model="productPrice"> ' +
        '<label>Product Image:</label> <input type="text" v-model="productImage"> </div> ' +
        '<div v-if="productType === Switch"> ' +
        '<label>Product Name:</label> <input type="text" v-model="productName"> ' +
        '<label>Product Brand:</label> <input type="text" v-model="productBrand"> ' +
        '<label>Product Feedback:</label> <input type="text" v-model="productFeedback"> ' +
        '<label>Product Pretravel:</label> <input type="text" v-model="productPretravel"> ' +
        '<label>Product Price:</label> <input type="text" v-model="productPrice"> ' +
        '<label>Product Image:</label> <input type="text" v-model="productImage"> </div> ' +
        '<input type="button" @click="save" >Submit</button> ' +
        '</div>',
    methods: {
        save: function () {
            var product = {
                productType: this.productType,
                productName: this.productName,
                productBrand: this.productBrand,
                productSize: this.productSize,
                productSwitch: this.productSwitch,
                productColours: this.productColours,
                productLayout: this.productLayout,
                productFeedback: this.productFeedback,
                productPretravel: this.productPretravel,
                productPrice: this.productPrice,
                productImage: this.productImage
            };
            mainApi.save({}, product).then(result =>
                result.json().then(data => {
                    this.messages.push(data);
                }));
        }
    }
});

Vue.component('product-row', {
    props: ['product'],
    template: '<div>Product</div>'
});

Vue.component('products-list', {
    props: ['products'],
    template: '<div>' +
        '<product-form :products="products"/> ' +
        '<product-row v-for="prod in products" :product="product">List</div> ' +
        '</div>',
    created: function () {
        mainApi.get().then(result =>
            result.json().then(data =>
                data.forEach(product => this.products.push(product))))
    }
})

var app = new Vue({
    el: '#app',
    template: '<products-list  :products="products"/>',
    data: {
        products: []
    }
})