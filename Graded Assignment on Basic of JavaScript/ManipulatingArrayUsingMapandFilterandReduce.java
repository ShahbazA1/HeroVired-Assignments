const customerData = [
  { customerID: 1, customerName: "John Doe", totalBillingAmount: 3500 },
  { customerID: 2, customerName: "Jane Smith", totalBillingAmount: 2800 },
  { customerID: 3, customerName: "Peter Jones", totalBillingAmount: 3200 },
];

const eligibleCustomers = customerData.filter(customer => customer.totalBillingAmount > 3000);

eligibleCustomers.forEach(customer => {
  console.log(`Customer Name: ${customer.customerName}`);
  console.log(`Customer ID: ${customer.customerID}`);
  console.log(`Total Billing Amount: ${customer.totalBillingAmount}`);
  console.log(`-------------------------------------`);
});
