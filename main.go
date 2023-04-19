package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

type Product struct {
	Id       int     `json:"id"`
	Name     string  `json:"name"`
	Quantity int     `json:"quantity"`
	Rate     float64 `json:"price"`
	Image    string  `json:"image"`
}

var products = []Product{
	{Id: 1, Name: "Cookies", Quantity: 10, Rate: 10.00, Image: " https://static.vecteezy.com/system/resources/previews/009/400/072/original/homemade-tasty-cookies-clipart-design-illustration-free-png.png"},
	{Id: 2, Name: "Milk", Quantity: 5, Rate: 20.00, Image: "https://cdn.shopify.com/s/files/1/0534/8674/7803/products/native_milk_2021_grande_609cf7d9-7a11-42b7-8a4d-e6d7751eae8b.png?v=1619469574"},
	{Id: 3, Name: "Candy", Quantity: 2, Rate: 5.00, Image: "https://cdn-icons-png.flaticon.com/512/6347/6347610.png"},
	{Id: 4, Name: "Coca Cola", Quantity: 4, Rate: 25.00, Image: "https://www.shortysliquor.com.au/media/catalog/product/cache/31c831e646b0e3d5fc6a02c7bbf2f6a4/c/o/coca_cola_24_x_375ml_cans_1_.png"},
	{Id: 5, Name: "Ice Cream", Quantity: 7, Rate: 5.00, Image: "https://cdn-icons-png.flaticon.com/512/6639/6639755.png"},
	{Id: 6, Name: "Snickers", Quantity: 8, Rate: 8.00, Image: "https://www.snickers.com/sites/g/files/fnmzdf616/files/migrate-product-files/dryeqrv2efldaaoyceat.png"},
}

func main() {
	r := gin.Default()

	r.Use(func(c *gin.Context) {

		c.Writer.Header().Set("Access-Control-Allow-Origin", "*")
		c.Writer.Header().Set("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE")
		c.Writer.Header().Set("Access-Control-Allow-Headers", "Content-Type")
		if c.Request.Method == "OPTIONS" {
			c.AbortWithStatus(http.StatusNoContent)
			return
		}
		c.Next()
	})

	r.GET("/api/products", func(c *gin.Context) {
		c.JSON(http.StatusOK, products)
	})

	r.Run(":8080")

}
