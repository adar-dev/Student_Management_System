import React, { useState } from 'react'

export default function Home() {

    return (
        <div className='container'>
            <div className='py-4'>
                <table className="table border shadow">
                    <thead className="table-secondary">
                        <tr>
                            <th scope="col">Roll No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Physics</th>
                            <th scope="col">Chemistry</th>
                            <th scope="col">Biology</th>
                            <th scope="col">Division</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>Mark</td>
                            <td>80</td>
                            <td>86</td>
                            <td>70</td>
                            <td>1</td>
                            <td>
                                <button className="btn btn-primary mx-2">View Report</button>
                                <button className="btn btn-primary mx-2">Update</button>
                                <button className="btn btn-primary mx-2">Delete</button>
                            </td>
                        </tr>
                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}
