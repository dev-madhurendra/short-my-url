# Short My URL

## Problem Statement

In the era of long URLs, users often find it challenging to share or remember them. The goal of this project is to create a URL Shortening service that takes long URLs and converts them into shorter, more manageable links. This service should also provide the ability to retrieve the original URL from the shortened version.

## Use Case

```
Hi Your-Client,
We welcome you to the biggest sale of the year. 
Get best offers at :  https://www.google.com/search?q=rajnikant&rlz=1C5CHFA_enIN961IN961&sxsrf=ALeKk01CgCbCOvDbH0-6362aa24dzoB4zg:1627480763291&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiD5Zim9oXyAhX-wTgGHTDvDMUQ_AUoAnoECAEQBA&biw=1792&bih=898
```


```
Hi Your-Client,
We welcome you to the biggest sale of the year. 
Get best offers at : https://www.zipurl.com/v1Wx4b/
```

## Solution

Our solution involves the creation of a URL Shortening service that generates unique short codes for each long URL. Users can then use these short codes to access the original URL. Additionally, we store mapping information between short and original URLs for quick retrieval.

## Possible Issues

- **Security Concerns:** Ensure that the shortened URLs are not susceptible to attacks like information disclosure or misuse.
- **Scalability:** Multiple User can request to shorten the same original url, in that
case the algorithm can generate the same hash for the url but we can avoid this by appending a increase number of the url before generating its hash in this case generated hash will always be unique but number can grow large need other alternative.
- **Redirection Performance:** Optimize the redirection process for the best user experience.


### Components

- **URL Shortening API:** Responsible for generating short URLs and handling redirection requests.
- **Database:** Stores the mapping between short and original URLs.
- **Frontend (Optional):** Provides a user interface for URL shortening.

### Workflow

1. User submits a long URL to the URL Shortening API.
2. API generates a unique short code and stores the mapping in the database.
3. API returns the shortened URL to the user.
4. When someone accesses the shortened URL, the API looks up the mapping and redirects to the original URL.

### System Design
https://miro.medium.com/v2/resize:fit:720/format:webp/1*HeDm_FpLVoR3d97NKdKNLw.png

## Tech Stack

- **Backend:** Spring Boot (Java).
- **Database:** MongoDB, In memory (development)
- **Frontend:** React
- **Deployment:** Docker

## Getting Started

1. Clone the repository.
2. Install dependencies.
3. Configure the database.
4. Run the application.

## Contributors

- Madhurendra Nath Tiwari - [GitHub Profile](https://github.com/dev-madhurendra)

## License

This project is licensed under the [MIT License](LICENSE).
