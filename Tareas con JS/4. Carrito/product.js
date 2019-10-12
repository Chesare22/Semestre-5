let productCount = 0

class Product {
  constructor(name, price, shipping, ammount) {
    this.name = name
    this.price = price
    this.shipping = shipping
    this.ammount = ammount >= 0 ? ammount : 1

    this.id = productCount
    productCount++
  }

  increaseAmmount() {
    this.ammount++
  }
  decreaseAmmount() {
    this.ammount -= 1
  }
}

function objectsToProducts(objects) {
  const products = []
  objects.forEach(({ name, price, shipping, ammount }) => {
    products.push(new Product(name, price, shipping, ammount))
  });
  return products
}