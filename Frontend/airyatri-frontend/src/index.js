import React from 'react';
import ReactDOM from 'react-dom/client';
// import './index.css';
import Launcher from './Launcher';
import Launcher1 from './Launcher1';

// import SignIn from './signin';
import {BrowserRouter} from 'react-router-dom';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<BrowserRouter>
<Launcher1/>
</BrowserRouter>);

// root.render(<SignIn/>);

