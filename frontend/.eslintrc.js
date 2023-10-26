module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: [
    'plugin:vue/vue3-essential',
    'eslint:recommended',
  ],
  overrides: [
    {
      files: ['*.js'],
      parser: '@babel/eslint-parser',
    },
  ],
  parserOptions: {
    parser: '@babel/eslint-parser',
    requireConfigFile: false,
  },
  rules: {
    
  },
};
