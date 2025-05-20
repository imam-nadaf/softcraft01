
### Class Design for Online Bookstore System

#### Class: Book
**Description**: Represents a book in the bookstore with details like title, author, price, and genre.
- **Attributes**:
  - `bookId: String` (Unique identifier for the book)
  - `title: String` (Title of the book)
  - `author: String` (Author of the book)
  - `price: Double` (Price of the book)
  - `genre: BookGenre` (Enum: FICTION, SCIENCE, HISTORY, PROGRAMMING)
  - `stockQuantity: Integer` (Available quantity in stock)
- **Methods**:
  - `getBookId(): String` (Returns book ID)
  - `getTitle(): String` (Returns book title)
  - `getAuthor(): String` (Returns author name)
  - `getPrice(): Double` (Returns book price)
  - `getGenre(): BookGenre` (Returns book genre)
  - `getStockQuantity(): Integer` (Returns available stock)
  - `updateStock(quantity: Integer): void` (Updates stock quantity)
  - `isAvailable(quantity: Integer): Boolean` (Checks if requested quantity is available)

#### Enum: BookGenre
**Description**: Defines the possible genres for books.
- **Values**:
  - `FICTION`
  - `SCIENCE`
  - `HISTORY`
  - `PROGRAMMING`

#### Class: ShoppingCart
**Description**: Manages the user's shopping cart, allowing books to be added, removed, or modified.
- **Attributes**:
  - `cartId: String` (Unique identifier for the cart)
  - `items: List<CartItem>` (List of items in the cart)
  - `userId: String` (Identifier of the user owning the cart)
- **Methods**:
  - `addItem(book: Book, quantity: Integer): void` (Adds a book with specified quantity to the cart)
  - `removeItem(bookId: String): void` (Removes a book from the cart)
  - `updateQuantity(bookId: String, quantity: Integer): void` (Updates quantity of a book in the cart)
  - `getItems(): List<CartItem>` (Returns list of cart items)
  - `getTotalPrice(): Double` (Calculates total price of items in the cart)
  - `clearCart(): void` (Empties the cart)

#### Class: CartItem
**Description**: Represents an item in the shopping cart, linking a book with its quantity.
- **Attributes**:
  - `book: Book` (Reference to the book)
  - `quantity: Integer` (Number of copies of the book)
- **Methods**:
  - `getBook(): Book` (Returns the book)
  - `getQuantity(): Integer` (Returns the quantity)
  - `setQuantity(quantity: Integer): void` (Updates the quantity)
  - `getSubtotal(): Double` (Calculates subtotal for this item: price * quantity)

#### Class: Order
**Description**: Represents a user's order, including items and order status.
- **Attributes**:
  - `orderId: String` (Unique identifier for the order)
  - `userId: String` (Identifier of the user placing the order)
  - `orderItems: List<OrderItem>` (List of items in the order)
  - `orderDate: Date` (Date the order was placed)
  - `status: OrderStatus` (Enum: PENDING, SHIPPED, DELIVERED, CANCELED)
  - `totalAmount: Double` (Total cost of the order)
- **Methods**:
  - `getOrderId(): String` (Returns order ID)
  - `getUserId(): String` (Returns user ID)
  - `getOrderItems(): List<OrderItem>` (Returns list of order items)
  - `getOrderDate(): Date` (Returns order date)
  - `getStatus(): OrderStatus` (Returns current order status)
  - `updateStatus(status: OrderStatus): void` (Updates order status)
  - `getTotalAmount(): Double` (Returns total amount of the order)
  - `createOrder(cart: ShoppingCart): void` (Creates order from cart contents)

#### Enum: OrderStatus
**Description**: Defines the possible statuses for an order.
- **Values**:
  - `PENDING`
  - `SHIPPED`
  - `DELIVERED`
  - `CANCELED`

#### Class: OrderItem
**Description**: Represents an item in an order, linking a book with its quantity and price at the time of order.
- **Attributes**:
  - `book: Book` (Reference to the book)
  - `quantity: Integer` (Number of copies ordered)
  - `priceAtOrder: Double` (Price of the book at the time of order)
- **Methods**:
  - `getBook(): Book` (Returns the book)
  - `getQuantity(): Integer` (Returns the quantity)
  - `getPriceAtOrder(): Double` (Returns the price at the time of order)
  - `getSubtotal(): Double` (Calculates subtotal: priceAtOrder * quantity)

#### Class: User
**Description**: Represents a user of the bookstore system.
- **Attributes**:
  - `userId: String` (Unique identifier for the user)
  - `name: String` (User's name)
  - `email: String` (User's email address)
  - `address: String` (User's shipping address)
- **Methods**:
  - `getUserId(): String` (Returns user ID)
  - `getName(): String` (Returns user name)
  - `getEmail(): String` (Returns user email)
  - `getAddress(): String` (Returns user address)
  - `updateAddress(address: String): void` (Updates user address)

#### Class: Bookstore
**Description**: Manages the bookstore's inventory and processes user interactions.
- **Attributes**:
  - `books: List<Book>` (List of all books in the bookstore)
  - `orders: List<Order>` (List of all orders)
  - `users: List<User>` (List of registered users)
- **Methods**:
  - `addBook(book: Book): void` (Adds a book to the inventory)
  - `removeBook(bookId: String): void` (Removes a book from the inventory)
  - `searchBooksByTitle(title: String): List<Book>` (Searches books by title)
  - `searchBooksByAuthor(author: String): List<Book>` (Searches books by author)
  - `searchBooksByGenre(genre: BookGenre): List<Book>` (Searches books by genre)
  - `placeOrder(userId: String, cart: ShoppingCart): Order` (Creates and returns a new order)
  - `getOrderStatus(orderId: String): OrderStatus` (Returns status of an order)
  - `updateOrderStatus(orderId: String, status: OrderStatus): void` (Updates status of an order)
  - `getUserOrders(userId: String): List<Order>` (Returns all orders for a user)

### Notes
- **Relationships**:
  - `Bookstore` manages multiple `Book`, `Order`, and `User` instances.
  - `ShoppingCart` contains multiple `CartItem` instances, each referencing a `Book`.
  - `Order` contains multiple `OrderItem` instances, each referencing a `Book`.
  - `User` is associated with one `ShoppingCart` and multiple `Order` instances.
