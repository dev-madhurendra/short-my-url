import { render,screen } from "@testing-library/react"
import Micrsoft from '../../../../public/assets/images/microsoft.svg';
import IconComponent from ".";

it('render icon',()=>{
    render(<IconComponent src={Micrsoft} height="32px" width="32px" padding="5px"/>)
    const icon = screen.getByTestId("iconComponent")
    expect(icon).toBeDefined()
})
