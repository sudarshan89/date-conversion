Custom JSON de-serialization with Mule API Kit Router
==

## Problem statement

I want to customise the serialization process when a JSON response is returned by the API Kit Router in Mule.

Assume I have a User object like the below

```

import java.util.Date;

public class User {

	private Date dateOfBirth;
	
	public User(Date dateOfBirth) {
		super();
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
```

When this object is returned by Mule in JSON format.The default output is like the below

```
{
  "dateOfBirth": 1456013856318
}
```


The desired output is like the below

```
{
  "dateOfBirth": "21-02-2016"
}
```

## Solution

#### Limitation

APIKit Router does not provide a way to inject a custom de-seriliazation strategy.

#### Workaround

###### Two options

1. Preventively convert the response to a Json string with a controlled ObjectToJson transformer.

2. Use ```@JsonSerialize``` and annotate the object model.

```
	@JsonSerialize(using = co.nz.tenzing.JsonDateSerializer.class, include=JsonSerialize.Inclusion.NON_NULL)
	private Date dateOfBirth;

```

Files that do the magic.

* [JsonDateSerializer](https://github.com/sudarshan89/date-conversion/blob/master/src/main/java/co/nz/tenzing/JsonDateSerializer.java)
* [User](https://github.com/sudarshan89/date-conversion/blob/master/src/main/java/co/nz/tenzing/User.java)

