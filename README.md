# rabbitmqPub


Posting a message to a rabbitMQ queue.
Create a queue in locallhost. Create an applcaition.yml file in your local and add properties :


queue:
  name: QUEUE_NAME
  exchange-name: EXCAHNGE_NAME
  excahnge-type: EXCHANGE_TYE
  routing-key: ROUTING_KEY

logging.level.org.springframework.web: DEBUG
