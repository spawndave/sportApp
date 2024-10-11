/** @type {import('tailwindcss').Config} */
const defaultTheme = require('tailwindcss/defaultTheme');
module.exports = {
  content: [
            "../resources/templates/**/*.{html, js}",
            "./node_modules/flowbite/**/*.js"],
  theme: {
    extend: {
      colors: {
        'taming-thymeleaf-green':'darkseagreen'
      }
    }
  },
  plugins: [
    require('@tailwindcss/forms'),
    require('flowbite/plugin')
  ],
}