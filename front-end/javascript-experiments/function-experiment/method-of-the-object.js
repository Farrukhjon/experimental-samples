var obj = {

    prop: "Hello ",

    hello: function (param) {
        console.log(this.prop + param);
    }
};

obj.hello("World!");