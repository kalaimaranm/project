import './App.css';
import {
  BrowserRouter
} from 'react-router-dom';
import { ThemeProvider,createTheme } from '@mui/material'
import { appTheme } from './Theme/theme';
import Routers from './Routers/router';

function App() {
  return (
    <BrowserRouter>
    <ThemeProvider theme={appTheme}>
      <Routers/>
    </ThemeProvider>
    </BrowserRouter>
  );
}

export default App;
