# Postman commands
| Command Name | Command |
|--------------|---------|
|              |         |


### Checks
    Collection
    Environment Variables
    Global Variables
    Request
    

### Validations
**Check Status Code**
```javascript
//**Verify that the response status code is what you expect (e.g., 200 OK)**
pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});
```
***Validate Response Time***
```javascript
    //**Ensure the response time is within acceptable limits**
    pm.test("Response time is less than 200ms", function () {
    pm.expect(pm.response.responseTime).to.be.below(200);
    });
```
**Check Response Body**
```javascript
    //**Validate specific values in the response body**
    pm.test("Response body contains userId 1", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.userId).to.eql(1);
    });
```
**Validate Content Type**
```javascript
    //**Check that the response has the correct content type**
    pm.test("Content-Type is present and is JSON", function () {
    pm.expect(pm.response.headers.get('Content-Type')).to.include('application/json');
    });
```
**Check for Specific Fields**
```javascript
    //**Ensure certain fields exist in the response**
    pm.test("Response has title field", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData).to.have.property('title');
    });
```
**Validate Length of Array**
```javascript
    //**If the response contains an array, you might want to check its length**
    pm.test("Response array has more than 0 items", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.items).to.have.length.greaterThan(0);
    });
```