console.log(process.env.NODE_ENV);
module.exports = {
  content: ["./**/*.html"],
  mode: 'jit',
  purge: [
    './public/**/*.html',
  ],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [],
}