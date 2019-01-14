# Broom (RESTful web service to cleanup data)
## Development Environment
|                     |                                 |
|---------------------|---------------------------------|
| **OS**              | Linux Mint                      |
| **Kernel**          | x86_64 Linux 4.15.0-43-generic  |
| **JDK**             | OpenJDK 1.8                     |
| **IDE**             | Spring Tool Suite 3.9.7         |
| **Version control** | Git 2.19.1 / GitHub             |
| **Build automation**| Gradle 5.1                      |

## Deployment
1. Clone or download and unzip the contents of this repository
2. Navigate to the root of this repository
3. The application was built using gradle, so simply run ./gradlew bootRun to get it started.

## Endpoints
The services' functionality is exposed in the following addresses:
### Categories
| Feature               | Endpoint                                                    |
|-----------------------|-------------------------------------------------------------|
| List Valid Categories | GET http://server_name:8080/category                       |
| Add Category          | PUT http://server_name:8080/category?name=category_name     |
| Delete Category       | DELETE http://server_name:8080/category?name=category_name  |
  
### Pairs
| Feature         | Endpoint                                                   |
|---------------- |------------------------------------------------------------|
| Cleanup feature | POST http://server_name:8080/pair                         |

**NOTE:** The body for this request must consist of a valid JSON string (see format in next section)

## Input/Output format for pairing requests
### Input
The body of the POST request to /pair must follow the format exemplified by the following snippet:
```[
  {
    "category":"PERSON",
    "subCategory":"Bob Jones"
  },
  {
    "category":"PLACE",
    "subCategory":"Washington"
  },
  {
    "category":"PERSON",
    "subCategory":"Mary"
  },
  {
    "category":"COMPUTER",
    "subCategory":"Mac"
  },
  {
    "category":"PERSON",
    "subCategory":"Bob Jones"
  },
  {
    "category":"OTHER",
    "subCategory":"Tree"
  },
  {
    "category":"ANIMAL",
    "subCategory":"Dog"
  },
  {
    "category":"PLACE",
    "subCategory":"Texas"
  },
  {
    "category":"FOOD",
    "subCategory":"Steak"
  },
  {
    "category":"ANIMAL",
    "subCategory":"Cat"
  },
  {
    "category":"PERSON",
    "subCategory":"Mac"
  }
]
```

### Output
After cleaning up and processing the input, the service will reply with a JSON string that implements the following format:
```{
  "processedList": [
    {
      "category": {
        "name": "PERSON"
      },
      "subCategory": "Bob Jones"
    },
    {
      "category": {
        "name": "PLACE"
      },
      "subCategory": "Washington"
    },
    {
      "category": {
        "name": "PERSON"
      },
      "subCategory": "Mary"
    },
    {
      "category": {
        "name": "COMPUTER"
      },
      "subCategory": "Mac"
    },
    {
      "category": {
        "name": "OTHER"
      },
      "subCategory": "Tree"
    },
    {
      "category": {
        "name": "ANIMAL"
      },
      "subCategory": "Dog"
    },
    {
      "category": {
        "name": "PLACE"
      },
      "subCategory": "Texas"
    },
    {
      "category": {
        "name": "ANIMAL"
      },
      "subCategory": "Cat"
    },
    {
      "category": {
        "name": "PERSON"
      },
      "subCategory": "Mac"
    }
  ],
  "count": [
    {
      "category": {
        "name": "PERSON"
      },
      "occurrences": 3
    },
    {
      "category": {
        "name": "ANIMAL"
      },
      "occurrences": 2
    },
    {
      "category": {
        "name": "PLACE"
      },
      "occurrences": 2
    },
    {
      "category": {
        "name": "OTHER"
      },
      "occurrences": 1
    },
    {
      "category": {
        "name": "COMPUTER"
      },
      "occurrences": 1
    }
  ]
}
```

## Monitoring
SpringBoot supplies a set of *Production-ready endpoints* intended to provide monitoring capabilities. For example, http://localhost:8080/metrics shows 'metrics' information for the application. Refer to https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html for the full list of endpoints.
