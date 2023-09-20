// export const ThemeInput = {
//     palette: {
//         primary:{
//             main:'#c68787',
//         }
//     },
//     components:{

//     }
//

import { createTheme } from '@mui/material';

const font = "'Poppins', sans-serif";

export const appTheme = createTheme({
  breakpoints: {
    values: {
      xs: 0,
      sm: 600,
      md: 1000,
      lg: 1200,
      xl: 1920
    }
  },
  components: {

    MuiDrawer: {
      styleOverrides: {

        paper: {
          backgroundColor: '#00349e',
          color: "white",
          boxSizing: "border-box",
        }
      }
    },
    MuiTableBody: {
      styleOverrides: {
          root: {
              
              "& .MuiTableCell-root": {
                  padding: '10px',
                  borderCollapse: 'separate',
              },
          }
      }
  },


    MuiCssBaseline: {
      styleOverrides: {
        '*': {
          boxSizing: 'border-box',
          margin: 0,
          padding: 0
        },
        html: {
          MozOsxFontSmoothing: 'grayscale',
          WebkitFontSmoothing: 'antialiased',
          display: 'flex',
          flexDirection: 'column',
          minHeight: '100%',
          width: '100%'
        },
        body: {
          display: 'flex',

          flex: '1 1 auto',
          flexDirection: 'column',
          minHeight: '100%',
          width: '100%',

        },
        '#__next': {
          display: 'flex',
          flex: '1 1 auto',
          flexDirection: 'column',
          height: '100%',
          width: '100%'
        }
      }
    },


  },
  palette: {

    // divider: '#E6E8F0',
    primary: {
      main: '#00349e',
      light: '#009ed1',

    },
    secondary: {
      main: '#ee7a00',
      // light: '#3FC79A',
      dark: 'none',
      contrastText: '#FFFFFF'
    },
    success: {
      main: '#14B8A6',
      light: '#43C6B7',
      dark: '#0E8074',
      contrastText: '#FFFFFF'
    },
    info: {
      main: '#2196F3',
      light: '#64B6F7',
      dark: '#0B79D0',
      contrastText: '#FFFFFF'
    },
    warning: {
      main: '#FFB020',
      light: '#FFBF4C',
      dark: '#B27B16',

      contrastText: '#FFFFFF'
    },
    error: {
      main: '#D14343',
      light: '#DA6868',
      dark: '#922E2E',
      contrastText: '#FFFFFF'
    },
    text: {
      // primary: '#121828',
      secondary: '#65748B',
      disabled: 'rgba(55, 65, 81, 0.48)'
    }
  },
  shape: {
    borderRadius: 8
  },

  typography: {

    button: {
      fontWeight: 600
    },
    // fontFamily: '"Inter", -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji"',
    fontFamily: font,
    headingText: {
      fontSize: '1.2rem',
      fontWeight: 400,
      lineHeight: 1.5
    },
    body1: {
      fontSize: '1rem',
      fontWeight: 400,
      lineHeight: 1.5
    },
    body2: {
      fontSize: '0.9rem',
      fontWeight: 400,
      lineHeight: 1.57
    },
    subtitle1: {
      fontSize: '0.8rem',
      fontWeight: 400,
      lineHeight: 1.75
    },
    subtitle3: {

      fontSize: "0.79rem",
      fontWeight: 600,
      lineHeight: 1.57,
      color: "#8098af",

    },
    discountText: {

      fontSize: "0.9rem",

      fontWeight: 400,

      lineHeight: 1.57,

      color: "gray",

    },

    subtitle2: {
      fontSize: '0.78rem',
      fontWeight: 300,
      lineHeight: 1.57
    },
    overline: {
      fontSize: '0.75rem',
      fontWeight: 600,
      letterSpacing: '0.5px',
      lineHeight: 2.5,
      textTransform: 'uppercase'
    },
    addressCard: {
      fontSize: "0.967rem",
    },
    price: {
      color: "#EB7100",
      fontSize: "1rem",
      fontWeight: 'bold'
    },
    caption: {
      fontSize: '0.75rem',
      fontWeight: 400,
      lineHeight: 1.66
    },
    h1: {
      fontWeight: 700,
      fontSize: '3.5rem',
      lineHeight: 1.375
    },
    h2: {
      fontWeight: 700,
      fontSize: '3rem',
      lineHeight: 1.375
    },
    h3: {
      fontWeight: 700,
      fontSize: '2.25rem',
      lineHeight: 1.375
    },
    h4: {
      fontWeight: 700,
      fontSize: '2rem',
      lineHeight: 1.375
    },
    h5: {
      fontWeight: 600,
      fontSize: '1.5rem',
      lineHeight: 1.375
    },
    h6: {
      fontWeight: 420,
      fontSize: '1.125rem',
      lineHeight: 1.375
    }
  }
});