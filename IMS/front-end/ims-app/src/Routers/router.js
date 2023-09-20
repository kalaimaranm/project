import React from 'react';
import {Routes,Route} from 'react-router-dom';
import SamplePage from '../Pages/samplePage';

export default function Routers() {
    return (
        <Routes>
            <Route path="/" element={<SamplePage />} />  
        </Routes>
    );
}
