db.createUser({
  user: 'testuser',
  pwd: 'password',
  roles: [{ role: 'readWrite', db: 'my_database' }]
});

db.my_collection.insert({ name: 'Test Document' });
