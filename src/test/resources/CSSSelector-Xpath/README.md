# Comparison Summary CSS Selector - Xpath
| Scenario	                     | CSS Selector Example	 | XPath Example                                                    |
|-------------------------------|-----------------------|------------------------------------------------------------------|
| By ID                         | `#exampleId`          | `//*[@id='exampleId']`                                           |
| By Class                      | `.exampleClass`       | 	`//*[@class='exampleClass']`                                    |
| By Attribute	                 | `input[type='text']`  | 	`//input[@type='text']`                                         |
| Nested Elements (Child)       | `div > span`          | `//div/span`                                                     |
| Text Content	                 | Not Supported         | 	`//button[text()='Submit']`                                     |
| Parent Elements               | Not Supported         | `//span/parent::div`                                             |
| Partial Attribute/Class Match | `[class*='example']`	 | `//*[contains(@class, 'example')]`                               |
| Selecting by Index            | `div:nth-child(2)`    | `(//div)[2]`                                                     |
| Descendants                   | `div span`            | `//div//span`                                                    |
| Multiple Classes              | `.class1.class2`      | `//*[contains(@class, 'class1') and contains(@class, 'class2')]` |
