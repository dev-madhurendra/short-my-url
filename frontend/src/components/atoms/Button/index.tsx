import { Button, ButtonProps } from "@mui/material";

interface ButtonPropsInterface extends ButtonProps {}

const MuiButton = ({ ...buttonProps }: ButtonPropsInterface) => <Button {...buttonProps} disableElevation disableRipple />;

export default MuiButton;
