# Fawry-Internship-Challenge
## E-Commerce System 🛒

A simple Java-based e-commerce system designed for intermediate students.  
Demonstrates **core OOP concepts** like abstraction, inheritance, and interfaces, while simulating real-world operations like adding products to a cart, validating stock and expiry, and handling shipping and checkout.
![image](https://github.com/user-attachments/assets/221d68a5-0337-4d0a-afc4-1ac3d29863fe)


---

## 🚀 Features

- Define products with:
  - Name, Price, Quantity
  - Expiration date (for expirable items)
  - Shipping weight (for shippable items)
- Supports multiple product types:
  - 📦 **Shippable**: `Cheese`, `Biscuits`, `TV`
  - ❌ **Non-shippable**: `Scratch Card`
  - ⏰ **Expirable**: `Cheese`, `Biscuits`
  - 🔒 **Non-expirable**: `TV`, `Scratch Card`
- Cart system that:
  - Allows adding products with specific quantity
  - Prevents adding more than available stock
  - Prevents adding expired items
- Checkout process includes:
  - ❗ Error handling: empty cart, expired items, out-of-stock, insufficient balance
  - 📄 Receipt with subtotal, shipping fee, total paid, and customer balance
  - 📦 Shipping summary: items and total weight

---

## 📁 Structure

- `Product` (abstract base class)
- Interfaces:
  - `Shippable` (defines `getName()` and `getWeight()`)
  - `Expirable` (defines `isExpired()`)
- Classes:
  - **Product Types**: `Cheese`, `Biscuits`, `TV`, `MobileCard`
  - **Core Logic**: `Customer`, `Cart`, `CartItem`, `Checkout`, `ShippingService`
  - **App Entry**: `Main`

---

## 💡 Example Usage

```java
Cart cart = new Cart();
cart.add(cheese, 2);
cart.add(biscuits, 1);
cart.add(scratchCard, 1);
Checkout.process(customer, cart);
